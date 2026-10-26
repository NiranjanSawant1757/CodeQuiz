from typing import List, Optional
from pydantic import BaseModel, Field, field_validator


class MCQQuestion(BaseModel):
    id: str = Field(..., description="Unique question identifier")
    subject: str = Field(..., description="Programming language or subject")
    difficulty: str = Field(..., description="Difficulty level: Beginner, Intermediate, or Advanced")
    question_text: str = Field(..., description="The multiple choice question text")
    options: List[str] = Field(..., description="Exactly four distinct answer options")
    correct_answer: str = Field(..., description="The correct answer text, matching one of the options")
    explanation: str = Field(..., description="Brief explanation why the answer is correct")

    @field_validator("options")
    @classmethod
    def validate_options_count(cls, v: List[str]) -> List[str]:
        if len(v) != 4:
            raise ValueError(f"Each question must contain exactly 4 options, found {len(v)}")
        clean_opts = [opt.strip() for opt in v if opt and opt.strip()]
        if len(clean_opts) != 4:
            raise ValueError("All 4 options must be non-empty strings")
        return clean_opts

    @field_validator("correct_answer")
    @classmethod
    def validate_correct_answer_in_options(cls, v: str, info) -> str:
        clean_answer = v.strip() if v else ""
        if not clean_answer:
            raise ValueError("Correct answer cannot be blank")
        
        # Check if options are present in data
        options = info.data.get("options")
        if options and clean_answer not in options:
            # Check case-insensitive match or match by option prefix (e.g. "A) ...")
            matched = False
            for opt in options:
                if opt.strip().lower() == clean_answer.lower():
                    clean_answer = opt
                    matched = True
                    break
            if not matched:
                raise ValueError(f"Correct answer '{clean_answer}' is not one of the 4 options: {options}")
        return clean_answer


class GenerateMCQRequest(BaseModel):
    subject: str = Field(..., description="Subject: Java, Python, C, C++, SQL, JavaScript, React")
    difficulty: str = Field(..., description="Difficulty: Beginner, Intermediate, Advanced")
    count: int = Field(..., description="Number of questions: 10, 20, 30, 50")

    @field_validator("subject")
    @classmethod
    def validate_subject(cls, v: str) -> str:
        valid_subjects = ["Java", "Python", "C", "C++", "SQL", "JavaScript", "React"]
        for s in valid_subjects:
            if s.lower() == v.strip().lower():
                return s
        raise ValueError(f"Unsupported subject '{v}'. Supported subjects: {', '.join(valid_subjects)}")

    @field_validator("difficulty")
    @classmethod
    def validate_difficulty(cls, v: str) -> str:
        valid_diffs = ["Beginner", "Intermediate", "Advanced", "Easy", "Medium", "Hard"]
        diff_map = {
            "easy": "Beginner",
            "beginner": "Beginner",
            "medium": "Intermediate",
            "intermediate": "Intermediate",
            "hard": "Advanced",
            "advanced": "Advanced"
        }
        lower = v.strip().lower()
        if lower in diff_map:
            return diff_map[lower]
        raise ValueError(f"Unsupported difficulty '{v}'. Supported: Beginner, Intermediate, Advanced")

    @field_validator("count")
    @classmethod
    def validate_count(cls, v: int) -> int:
        valid_counts = [10, 20, 30, 50]
        if v not in valid_counts:
            # Allow fallback if close, otherwise raise
            if v > 0 and v <= 50:
                return v
            raise ValueError(f"Count must be one of {valid_counts}")
        return v


class GenerateMCQResponse(BaseModel):
    success: bool
    subject: str
    difficulty: str
    count: int
    questions: List[MCQQuestion]
    message: Optional[str] = None


class HealthResponse(BaseModel):
    status: str
    service: str
    ai_configured: bool
    model: str
