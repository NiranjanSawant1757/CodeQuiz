package com.example.codequiz.util;

public class AppConstants {
    // Intent Extras
    public static final String EXTRA_CATEGORY = "extra_category";
    public static final String EXTRA_CATEGORY_NAME = "extra_category_name";
    public static final String EXTRA_DIFFICULTY = "extra_difficulty";
    public static final String EXTRA_QUESTION_COUNT = "extra_question_count";
    public static final String EXTRA_TIMER_ENABLED = "extra_timer_enabled";
    public static final String EXTRA_ATTEMPT_ID = "extra_attempt_id";

    // Difficulty Options
    public static final String DIFFICULTY_EASY = "Easy";
    public static final String DIFFICULTY_MEDIUM = "Medium";
    public static final String DIFFICULTY_HARD = "Hard";
    public static final String DIFFICULTY_MIXED = "Mixed";

    // Question Counts
    public static final int COUNT_10 = 10;
    public static final int COUNT_20 = 20;
    public static final int COUNT_30 = 30;
    public static final int COUNT_50 = 50;

    // Categories
    public static final String CAT_JAVA = "Java";
    public static final String CAT_PYTHON = "Python";
    public static final String CAT_C = "C";
    public static final String CAT_CPP = "C++";
    public static final String CAT_JAVASCRIPT = "JavaScript";
    public static final String CAT_REACT = "React";
    public static final String CAT_HTML = "HTML";
    public static final String CAT_CSS = "CSS";
    public static final String CAT_SQL = "SQL";
    public static final String CAT_DSA = "Data Structures and Algorithms";

    // Default Timer: 45 seconds per question
    public static final int DEFAULT_SECONDS_PER_QUESTION = 45;
}
