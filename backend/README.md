# CodeQuiz AI MCQ Generation Backend

This backend service acts as a secure intermediary between the **CodeQuiz Android Application** and the AI provider. It ensures that the AI API key remains completely protected on the server and is never exposed to the client or embedded in the APK.

## Features
- **API Key Security**: The AI API key is read from server environment variables and never sent to Android clients or logged.
- **Strict Validation**: Validates all incoming parameters (Subject, Difficulty, Count) and AI responses (4 options per question, verified correct answer, non-empty explanation).
- **Graceful Error Handling**: Detects quota exhaustion, server timeouts, malformed responses, and network failures.
- **CORS & Emulator Support**: Compatible with Android Emulator (`http://10.0.2.2:8000`) and physical devices on local network (`http://<PC-IP>:8000`).

---

## Prerequisites
- Python 3.9+ (Python 3.12 recommended)
- `pip` package manager

---

## Setup Instructions

### 1. Navigate to the backend directory
```bash
cd backend
```

### 2. (Optional but recommended) Create a virtual environment
```bash
python -m venv venv
# On Windows:
.\venv\Scripts\activate
# On Linux/macOS:
source venv/bin/activate
```

### 3. Install required packages
```bash
pip install -r requirements.txt
```

### 4. Configure Environment Variables
Copy the `.env.example` file to `.env`:
```bash
cp .env.example .env
```
Open `.env` and configure your API key:
```env
AI_API_KEY=your_actual_api_key_here
AI_MODEL_NAME=gemini-1.5-flash
HOST=0.0.0.0
PORT=8000
```
> **Security Note**: Never commit your `.env` file to version control. The `.gitignore` has been updated to ignore `.env` files automatically.

---

## Running the Server

Start the FastAPI server using Uvicorn:
```bash
uvicorn main:app --host 0.0.0.0 --port 8000 --reload
```
Or directly run:
```bash
python main.py
```

The server will be available at:
- **Local machine**: `http://localhost:8000`
- **Android Emulator**: `http://10.0.2.2:8000`
- **Interactive API Docs (Swagger)**: `http://localhost:8000/docs`

---

## API Endpoints

### 1. Health Check
- **Endpoint**: `GET /health`
- **Description**: Verifies that the service is running and reports whether the AI key is configured.
- **Sample Response**:
  ```json
  {
    "status": "ok",
    "service": "CodeQuiz AI Backend",
    "ai_configured": true,
    "model": "gemini-1.5-flash"
  }
  ```

### 2. Generate MCQs
- **Endpoint**: `POST /api/generate-mcqs`
- **Request Body**:
  ```json
  {
    "subject": "Java",
    "difficulty": "Beginner",
    "count": 10
  }
  ```
- **Supported Subjects**: `Java`, `Python`, `C`, `C++`, `SQL`, `JavaScript`, `React`
- **Supported Difficulties**: `Beginner`, `Intermediate`, `Advanced`
- **Supported Counts**: `10`, `20`, `30`, `50`
- **Sample Response**:
  ```json
  {
    "success": true,
    "subject": "Java",
    "difficulty": "Beginner",
    "count": 10,
    "questions": [
      {
        "id": "ai_java_01",
        "subject": "Java",
        "difficulty": "Beginner",
        "question_text": "What is the size of an int variable in Java?",
        "options": [
          "16 bits",
          "32 bits",
          "64 bits",
          "8 bits"
        ],
        "correct_answer": "32 bits",
        "explanation": "In Java, an int is a 32-bit signed two's complement integer."
      }
    ],
    "message": "Generated 10 Beginner Java questions successfully."
  }
  ```
