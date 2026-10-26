import unittest
from fastapi.testclient import TestClient
from main import app
from models import MCQQuestion, GenerateMCQRequest

client = TestClient(app)


class BackendTestCase(unittest.TestCase):
    def test_health_check(self):
        response = client.get("/health")
        self.assertEqual(response.status_code, 200)
        data = response.json()
        self.assertEqual(data["status"], "ok")
        self.assertEqual(data["service"], "CodeQuiz AI Backend")
        self.assertIn("ai_configured", data)

    def test_mcq_model_validation_valid(self):
        q = MCQQuestion(
            id="q1",
            subject="Java",
            difficulty="Beginner",
            question_text="What is the default value of boolean in Java?",
            options=["true", "false", "null", "0"],
            correct_answer="false",
            explanation="The default boolean field value in Java is false."
        )
        self.assertEqual(q.correct_answer, "false")
        self.assertEqual(len(q.options), 4)

    def test_mcq_model_invalid_options(self):
        with self.assertRaises(Exception):
            MCQQuestion(
                id="q2",
                subject="Java",
                difficulty="Beginner",
                question_text="Invalid question?",
                options=["true", "false"], # only 2 options
                correct_answer="false",
                explanation="Error test"
            )

    def test_mcq_model_correct_answer_not_in_options(self):
        with self.assertRaises(Exception):
            MCQQuestion(
                id="q3",
                subject="Python",
                difficulty="Intermediate",
                question_text="What keyword defines a function?",
                options=["func", "function", "define", "def"],
                correct_answer="method", # not in options!
                explanation="Error test"
            )

    def test_generate_request_validation(self):
        # Valid
        req = GenerateMCQRequest(subject="Java", difficulty="Beginner", count=10)
        self.assertEqual(req.subject, "Java")
        self.assertEqual(req.difficulty, "Beginner")
        self.assertEqual(req.count, 10)

        # Invalid subject
        with self.assertRaises(Exception):
            GenerateMCQRequest(subject="Cooking", difficulty="Beginner", count=10)

        # Invalid difficulty
        with self.assertRaises(Exception):
            GenerateMCQRequest(subject="Java", difficulty="SuperHard", count=10)


if __name__ == "__main__":
    unittest.main()
