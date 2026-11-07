package com.example.codequiz.model;

import androidx.annotation.ColorRes;
import androidx.annotation.RawRes;

import com.example.codequiz.R;

/**
 * 3-Level Quiz Achievement & Celebration Model.
 *
 * Level 1: PASS - Accuracy in [50%, 80%)
 * Level 2: INTERMEDIATE - Accuracy in [80%, 95%)
 * Level 3: BEST - Accuracy >= 95%
 * FAIL: Accuracy < 50% (preserves existing passing criteria)
 */
public enum AchievementLevel {
    FAIL(
            "FAIL",
            "Needs Improvement 📚",
            "Review the detailed answers below and study the explanations to master these topics.",
            0,
            R.color.incorrect_red,
            R.color.incorrect_red_light
    ),
    PASS(
            "PASS",
            "Good Job! 🎉",
            "Congratulations! You passed the quiz. Keep learning and improving!",
            R.raw.achievement_pass,
            R.color.info_blue,
            R.color.info_blue_light
    ),
    INTERMEDIATE(
            "INTERMEDIATE",
            "Excellent Work! 🌟",
            "Great performance! You are getting better. Keep it up!",
            R.raw.achievement_intermediate,
            R.color.purple,
            R.color.purple_light
    ),
    BEST(
            "BEST",
            "Outstanding! 🏆",
            "Amazing performance! You are a quiz champion!",
            R.raw.achievement_best,
            R.color.correct_green,
            R.color.correct_green_light
    );

    public static final double PASS_THRESHOLD = 50.0;
    public static final double INTERMEDIATE_THRESHOLD = 80.0;
    public static final double BEST_THRESHOLD = 95.0;

    private final String badgeText;
    private final String title;
    private final String message;
    @RawRes private final int gifResId;
    @ColorRes private final int badgeColorResId;
    @ColorRes private final int badgeBgColorResId;

    AchievementLevel(String badgeText, String title, String message, int gifResId, int badgeColorResId, int badgeBgColorResId) {
        this.badgeText = badgeText;
        this.title = title;
        this.message = message;
        this.gifResId = gifResId;
        this.badgeColorResId = badgeColorResId;
        this.badgeBgColorResId = badgeBgColorResId;
    }

    public String getBadgeText() {
        return badgeText;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    @RawRes
    public int getGifResId() {
        return gifResId;
    }

    @ColorRes
    public int getBadgeColorResId() {
        return badgeColorResId;
    }

    @ColorRes
    public int getBadgeBgColorResId() {
        return badgeBgColorResId;
    }

    public boolean hasAchievementGif() {
        return gifResId != 0;
    }

    public boolean isPassed() {
        return this != FAIL;
    }

    /**
     * Accuracy formula: (Correct Answers / Total Questions) * 100
     * Safely handles zero questions.
     */
    public static double calculateAccuracy(int correctAnswers, int totalQuestions) {
        if (totalQuestions <= 0) {
            return 0.0;
        }
        return ((double) correctAnswers / totalQuestions) * 100.0;
    }

    public static AchievementLevel classify(int correctAnswers, int totalQuestions) {
        if (totalQuestions <= 0) {
            return FAIL;
        }
        double accuracy = calculateAccuracy(correctAnswers, totalQuestions);
        return classify(accuracy);
    }

    public static AchievementLevel classify(double accuracy) {
        if (accuracy < PASS_THRESHOLD) {
            return FAIL;
        } else if (accuracy < INTERMEDIATE_THRESHOLD) {
            return PASS;
        } else if (accuracy < BEST_THRESHOLD) {
            return INTERMEDIATE;
        } else {
            return BEST;
        }
    }
}
