import os
from pathlib import Path
from dotenv import load_dotenv

# Load .env file from the backend folder or root
backend_env = Path(__file__).resolve().parent / ".env"
root_env = Path(__file__).resolve().parent.parent / ".env"

if backend_env.exists():
    load_dotenv(dotenv_path=backend_env)
elif root_env.exists():
    load_dotenv(dotenv_path=root_env)
else:
    load_dotenv()


class Settings:
    HOST: str = os.getenv("HOST", "0.0.0.0")
    PORT: int = int(os.getenv("PORT", "8000"))
    
    # AI API key loaded from environment (never hardcoded)
    AI_API_KEY: str = os.getenv("AI_API_KEY", "").strip()
    
    # Configurable AI Model
    AI_MODEL_NAME: str = os.getenv("AI_MODEL_NAME", "gemini-1.5-flash").strip()
    
    # Request timeouts & retries
    REQUEST_TIMEOUT_SECONDS: int = int(os.getenv("REQUEST_TIMEOUT_SECONDS", "45"))
    MAX_RETRIES: int = int(os.getenv("MAX_RETRIES", "2"))

    @property
    def is_ai_configured(self) -> bool:
        return bool(self.AI_API_KEY and self.AI_API_KEY != "YOUR_API_KEY_HERE")

    def masked_key(self) -> str:
        """Returns safe representation for logs without leaking secret."""
        if not self.is_ai_configured:
            return "NOT_CONFIGURED"
        if len(self.AI_API_KEY) <= 8:
            return "****"
        return f"{self.AI_API_KEY[:4]}...{self.AI_API_KEY[-4:]}"


settings = Settings()
