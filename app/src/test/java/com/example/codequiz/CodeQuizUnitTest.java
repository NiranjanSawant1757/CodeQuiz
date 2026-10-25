package com.example.codequiz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.example.codequiz.data.QuestionBank;
import com.example.codequiz.model.AnswerRecord;
import com.example.codequiz.model.Question;
import com.example.codequiz.model.QuizAttempt;
import com.example.codequiz.model.QuizCategory;
import com.example.codequiz.util.AppConstants;
import com.example.codequiz.util.PasswordUtils;
import com.example.codequiz.util.ValidationUtils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CodeQuizUnitTest {

    @Test
    public void testPasswordHashingAndVerification() {
        String password = "SecurePassword123!";
        String salt = PasswordUtils.generateSalt();
        assertNotNull(salt);
        assertEquals(32, salt.length()); // 16 bytes in hex = 32 chars

        String hash1 = PasswordUtils.hashPassword(password, salt);
        String hash2 = PasswordUtils.hashPassword(password, salt);

        // Deterministic hashing for identical salt
        assertEquals(hash1, hash2);

        // Verification success
        assertTrue(PasswordUtils.verifyPassword(password, salt, hash1));

        // Verification fail on incorrect password
        assertFalse(PasswordUtils.verifyPassword("WrongPassword", salt, hash1));

        // Different salt produces different hash
        String salt2 = PasswordUtils.generateSalt();
        String hash3 = PasswordUtils.hashPassword(password, salt2);
        assertNotEquals(hash1, hash3);
    }

    @Test
    public void testValidationUtils() {
        assertTrue(ValidationUtils.isValidEmail("student@university.edu"));
        assertTrue(ValidationUtils.isValidEmail("john.doe@gmail.com"));
        assertFalse(ValidationUtils.isValidEmail("not-an-email"));
        assertFalse(ValidationUtils.isValidEmail(""));
        assertFalse(ValidationUtils.isValidEmail(null));

        assertTrue(ValidationUtils.isValidUsername("developer_99"));
        assertTrue(ValidationUtils.isValidUsername("alex"));
        assertFalse(ValidationUtils.isValidUsername("al")); // too short (<3)
        assertFalse(ValidationUtils.isValidUsername("alex with spaces"));
        assertFalse(ValidationUtils.isValidUsername(null));

        assertTrue(ValidationUtils.isValidPassword("secret123"));
        assertFalse(ValidationUtils.isValidPassword("12345")); // < 6 chars
        assertFalse(ValidationUtils.isValidPassword(null));
    }

    @Test
    public void testQuestionBankCategories() {
        List<QuizCategory> categories = QuestionBank.getCategories();
        assertEquals(10, categories.size());

        String[] expectedCategories = {
                AppConstants.CAT_JAVA,
                AppConstants.CAT_PYTHON,
                AppConstants.CAT_C,
                AppConstants.CAT_CPP,
                AppConstants.CAT_JAVASCRIPT,
                AppConstants.CAT_REACT,
                AppConstants.CAT_HTML,
                AppConstants.CAT_CSS,
                AppConstants.CAT_SQL,
                AppConstants.CAT_DSA
        };

        for (String expectedCat : expectedCategories) {
            int count = QuestionBank.getCount(expectedCat);
            assertTrue("Category " + expectedCat + " should have at least 50 questions", count >= 50);

            // Check difficulty filtering availability
            int easyCount = QuestionBank.getAvailableCount(expectedCat, AppConstants.DIFFICULTY_EASY);
            int mediumCount = QuestionBank.getAvailableCount(expectedCat, AppConstants.DIFFICULTY_MEDIUM);
            int hardCount = QuestionBank.getAvailableCount(expectedCat, AppConstants.DIFFICULTY_HARD);
            int mixedCount = QuestionBank.getAvailableCount(expectedCat, AppConstants.DIFFICULTY_MIXED);

            assertTrue("Easy questions should be > 0", easyCount > 0);
            assertTrue("Medium questions should be > 0", mediumCount > 0);
            assertTrue("Hard questions should be > 0", hardCount > 0);
            assertEquals(count, mixedCount);
        }
    }

    @Test
    public void testQuestionIntegrity() {
        List<QuizCategory> categories = QuestionBank.getCategories();
        for (QuizCategory cat : categories) {
            List<Question> questions = QuestionBank.getQuizQuestions(cat.getName(), AppConstants.DIFFICULTY_MIXED, 50);
            assertEquals(50, questions.size());

            for (Question q : questions) {
                assertNotNull("Question text must not be null", q.getQuestionText());
                assertFalse("Question text must not be blank", q.getQuestionText().trim().isEmpty());
                assertEquals("Question must have exactly 4 options", 4, q.getOptions().size());
                assertNotNull("Correct answer must not be null", q.getCorrectAnswer());
                assertTrue("Correct answer must be present in options list for " + q.getId(),
                        q.getOptions().contains(q.getCorrectAnswer()));
                assertNotNull("Explanation must not be null", q.getExplanation());
                assertFalse("Explanation must not be empty", q.getExplanation().trim().isEmpty());
            }
        }
    }

    @Test
    public void testQuizRandomizationAndOptionIntegrity() {
        // Requesting 10 questions from Java
        List<Question> sample = QuestionBank.getQuizQuestions(AppConstants.CAT_JAVA, AppConstants.DIFFICULTY_MIXED, 10);
        assertEquals(10, sample.size());

        for (Question q : sample) {
            assertEquals(4, q.getOptions().size());
            assertTrue("Correct answer mapping must be preserved after shuffling",
                    q.getOptions().contains(q.getCorrectAnswer()));
        }
    }

    @Test
    public void testPerformanceLevelClassification() {
        QuizAttempt attempt1 = new QuizAttempt();
        attempt1.setPercentage(95.0);
        assertEquals("Excellent", attempt1.getPerformanceLevel());

        QuizAttempt attempt2 = new QuizAttempt();
        attempt2.setPercentage(80.0);
        assertEquals("Very Good", attempt2.getPerformanceLevel());

        QuizAttempt attempt3 = new QuizAttempt();
        attempt3.setPercentage(65.0);
        assertEquals("Good", attempt3.getPerformanceLevel());

        QuizAttempt attempt4 = new QuizAttempt();
        attempt4.setPercentage(42.5);
        assertEquals("Needs Improvement", attempt4.getPerformanceLevel());
    }

    @Test
    public void testAnswerRecordJsonSerialization() {
        AnswerRecord record = new AnswerRecord();
        record.setOptions(Arrays.asList("Option A", "Option B", "Option C", "Option D"));

        String json = record.getOptionsJson();
        assertNotNull(json);
        assertTrue(json.contains("Option A"));

        AnswerRecord restored = new AnswerRecord();
        restored.setOptionsFromJson(json);
        assertEquals(4, restored.getOptions().size());
        assertEquals("Option A", restored.getOptions().get(0));
        assertEquals("Option D", restored.getOptions().get(3));
    }
}
