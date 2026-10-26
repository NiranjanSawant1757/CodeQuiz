import json
import logging
import time
import uuid
from typing import List
import requests
from config import settings
from models import MCQQuestion

logger = logging.getLogger("CodeQuizAI")


class AIServiceException(Exception):
    def __init__(self, message: str, status_code: int = 500):
        super().__init__(message)
        self.message = message
        self.status_code = status_code


def build_prompt(subject: str, difficulty: str, count: int) -> str:
    return f"""You are a senior computer science examiner. Generate exactly {count} distinct, high-quality multiple choice questions (MCQs) for the subject "{subject}" at "{difficulty}" level.

Each question MUST strictly follow these rules:
1. Question text must be clear, unambiguous, and test real programming knowledge (syntax, core concepts, best practices, edge cases, or code analysis).
2. Exactly four (4) distinct, mutually exclusive answer options.
3. One unambiguous correct answer that EXACTLY matches one of the 4 options.
4. A concise, clear explanation (1-3 sentences) explaining why the correct answer is correct and why other choices are wrong.
5. Difficulty: "{difficulty}".
6. Subject: "{subject}".

You MUST output ONLY a valid JSON array of objects with NO markdown formatting, NO backticks, and NO surrounding text.
Each object must have the following fields:
- "id": string unique identifier
- "subject": "{subject}"
- "difficulty": "{difficulty}"
- "question_text": string
- "options": [string, string, string, string] (array of exactly 4 strings)
- "correct_answer": string (must be identical to one of the 4 options)
- "explanation": string
"""


def call_ai_service(subject: str, difficulty: str, count: int) -> List[MCQQuestion]:
    """
    Communicates securely with the AI provider using the backend-stored API key.
    Validates all questions and handles rate limits/errors gracefully.
    """
    if not settings.is_ai_configured:
        raise AIServiceException(
            "AI API key is not configured on the backend server. Please set your API key in the backend environment file (.env).",
            status_code=503
        )

    # Gemini REST API endpoint
    endpoint = f"https://generativelanguage.googleapis.com/v1beta/models/{settings.AI_MODEL_NAME}:generateContent"
    headers = {"Content-Type": "application/json"}
    params = {"key": settings.AI_API_KEY}

    prompt = build_prompt(subject, difficulty, count)

    payload = {
        "contents": [
            {
                "parts": [
                    {"text": prompt}
                ]
            }
        ],
        "generationConfig": {
            "temperature": 0.7,
            "responseMimeType": "application/json"
        }
    }

    last_error = None
    for attempt in range(settings.MAX_RETRIES + 1):
        try:
            logger.info(f"Calling AI service for {count} questions ({subject} - {difficulty}), attempt {attempt + 1}")
            response = requests.post(
                endpoint,
                headers=headers,
                params=params,
                json=payload,
                timeout=settings.REQUEST_TIMEOUT_SECONDS
            )

            if response.status_code == 200:
                data = response.json()
                raw_text = ""
                candidates = data.get("candidates", [])
                if candidates:
                    parts = candidates[0].get("content", {}).get("parts", [])
                    if parts:
                        raw_text = parts[0].get("text", "")

                if not raw_text:
                    raise AIServiceException("AI service returned an empty response.", status_code=502)

                # Clean markdown backticks if present
                clean_json_str = raw_text.strip()
                if clean_json_str.startswith("```json"):
                    clean_json_str = clean_json_str[7:]
                elif clean_json_str.startswith("```"):
                    clean_json_str = clean_json_str[3:]
                if clean_json_str.endswith("```"):
                    clean_json_str = clean_json_str[:-3]
                clean_json_str = clean_json_str.strip()

                try:
                    parsed_array = json.loads(clean_json_str)
                except json.JSONDecodeError as jde:
                    logger.error(f"JSON decode failure: {jde}. Raw snippet: {clean_json_str[:200]}")
                    raise AIServiceException("AI service generated an invalid JSON format.", status_code=502)

                if isinstance(parsed_array, dict) and "questions" in parsed_array:
                    parsed_array = parsed_array["questions"]

                if not isinstance(parsed_array, list):
                    raise AIServiceException("AI service did not return a list of questions.", status_code=502)

                validated_questions: List[MCQQuestion] = []
                for idx, item in enumerate(parsed_array):
                    try:
                        q_id = str(item.get("id") or f"ai_{subject.lower()}_{uuid.uuid4().hex[:8]}_{idx + 1}")
                        q = MCQQuestion(
                            id=q_id,
                            subject=subject,
                            difficulty=difficulty,
                            question_text=str(item.get("question_text", "")).strip(),
                            options=[str(opt).strip() for opt in item.get("options", [])],
                            correct_answer=str(item.get("correct_answer", "")).strip(),
                            explanation=str(item.get("explanation", "")).strip() or f"Correct answer for this {subject} concept."
                        )
                        validated_questions.append(q)
                    except Exception as ve:
                        logger.warning(f"Rejecting malformed question item {idx}: {ve}")
                        continue

                if len(validated_questions) == 0:
                    raise AIServiceException("Failed to validate any questions returned by the AI service.", status_code=502)

                logger.info(f"Successfully generated and validated {len(validated_questions)} questions.")
                return validated_questions

            elif response.status_code == 400:
                err_data = response.json() if response.text else {}
                msg = err_data.get("error", {}).get("message", "Invalid request parameters to AI service.")
                logger.error(f"AI Service 400 Bad Request: {msg}")
                raise AIServiceException(f"AI Service Request Error: {msg}", status_code=400)

            elif response.status_code == 401 or response.status_code == 403:
                logger.error("AI Service authentication failed. API credentials may be invalid.")
                raise AIServiceException("AI Service authentication failed. Please verify the API key on the backend server.", status_code=401)

            elif response.status_code == 429:
                logger.warning(f"AI Service rate limit / quota exceeded (attempt {attempt + 1}).")
                if attempt < settings.MAX_RETRIES:
                    time.sleep(2 * (attempt + 1))
                    continue
                raise AIServiceException("AI service quota or rate limit exceeded. Please try again in a few moments.", status_code=429)

            else:
                logger.error(f"AI Service error {response.status_code}: {response.text[:200]}")
                if attempt < settings.MAX_RETRIES:
                    time.sleep(2)
                    continue
                raise AIServiceException(f"AI service error (HTTP {response.status_code}). Please try again later.", status_code=502)

        except requests.exceptions.Timeout:
            logger.warning(f"AI Service request timed out (attempt {attempt + 1}).")
            if attempt < settings.MAX_RETRIES:
                time.sleep(1)
                continue
            raise AIServiceException("AI service request timed out. Please check backend internet connection and try again.", status_code=504)
        except requests.exceptions.RequestException as re:
            logger.error(f"Network error communicating with AI service: {re}")
            last_error = re
            if attempt < settings.MAX_RETRIES:
                time.sleep(1)
                continue
            raise AIServiceException("Backend network error connecting to AI service.", status_code=502)

    raise AIServiceException(f"AI question generation failed: {last_error}", status_code=500)
