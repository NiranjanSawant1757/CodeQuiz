import logging
import time
from fastapi import FastAPI, HTTPException, Request, status
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import JSONResponse

from config import settings
from models import (
    GenerateMCQRequest,
    GenerateMCQResponse,
    HealthResponse
)
from ai_service import call_ai_service, AIServiceException

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(name)s: %(message)s"
)
logger = logging.getLogger("CodeQuizServer")

app = FastAPI(
    title="CodeQuiz AI Backend",
    description="Secure AI MCQ generation service for CodeQuiz Android Application",
    version="1.0.0"
)

# Enable CORS for cross-origin and mobile client access
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


@app.on_event("startup")
async def startup_event():
    logger.info("==================================================")
    logger.info("Starting CodeQuiz AI Backend Server")
    logger.info(f"Host: {settings.HOST}:{settings.PORT}")
    logger.info(f"AI Service Configured: {settings.is_ai_configured} (Key: {settings.masked_key()})")
    logger.info(f"Configured Model: {settings.AI_MODEL_NAME}")
    logger.info("==================================================")


@app.get("/health", response_model=HealthResponse)
def health_check():
    """
    Health check endpoint for the Android client to verify backend connectivity.
    """
    return HealthResponse(
        status="ok",
        service="CodeQuiz AI Backend",
        ai_configured=settings.is_ai_configured,
        model=settings.AI_MODEL_NAME
    )


@app.post("/api/generate-mcqs", response_model=GenerateMCQResponse)
async def generate_mcqs(req: GenerateMCQRequest):
    """
    Generate validated MCQ questions using the configured AI service.
    Validates input parameters, securely requests questions, checks answer options,
    and returns a structured JSON payload to the Android client.
    """
    start_time = time.time()
    logger.info(f"Received question request: subject='{req.subject}', difficulty='{req.difficulty}', count={req.count}")

    try:
        questions = call_ai_service(req.subject, req.difficulty, req.count)
        elapsed = round(time.time() - start_time, 2)
        logger.info(f"Returning {len(questions)} validated questions in {elapsed}s")

        return GenerateMCQResponse(
            success=True,
            subject=req.subject,
            difficulty=req.difficulty,
            count=len(questions),
            questions=questions,
            message=f"Generated {len(questions)} {req.difficulty} {req.subject} questions successfully."
        )

    except AIServiceException as ae:
        logger.error(f"AIServiceException: {ae.message} (HTTP {ae.status_code})")
        raise HTTPException(status_code=ae.status_code, detail=ae.message)
    except Exception as e:
        logger.error(f"Unhandled error during MCQ generation: {str(e)}", exc_info=True)
        raise HTTPException(
            status_code=status.HTTP_500_INTERNAL_SERVER_ERROR,
            detail="An unexpected internal server error occurred while generating questions."
        )


@app.exception_handler(HTTPException)
async def http_exception_handler(request: Request, exc: HTTPException):
    return JSONResponse(
        status_code=exc.status_code,
        content={
            "success": False,
            "error": exc.detail,
            "status_code": exc.status_code
        }
    )


if __name__ == "__main__":
    import uvicorn
    uvicorn.run("main:app", host=settings.HOST, port=settings.PORT, reload=True)
