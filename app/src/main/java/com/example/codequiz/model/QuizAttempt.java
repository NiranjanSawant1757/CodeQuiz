package com.example.codequiz.model;

import java.io.Serializable;

public class QuizAttempt implements Serializable {
    private long id;
    private long userId;
    private String category;
    private String difficulty;
    private int totalQuestions;
    private int correctAnswers;
    private int incorrectAnswers;
    private int unanswered;
    private int score;
    private double percentage;
    private int durationSeconds;
    private long attemptedAt;

    public QuizAttempt() {
    }

    public QuizAttempt(long id, long userId, String category, String difficulty, int totalQuestions,
                       int correctAnswers, int incorrectAnswers, int unanswered, int score,
                       double percentage, int durationSeconds, long attemptedAt) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.difficulty = difficulty;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
        this.unanswered = unanswered;
        this.score = score;
        this.percentage = percentage;
        this.durationSeconds = durationSeconds;
        this.attemptedAt = attemptedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public int getUnanswered() {
        return unanswered;
    }

    public void setUnanswered(int unanswered) {
        this.unanswered = unanswered;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public long getAttemptedAt() {
        return attemptedAt;
    }

    public void setAttemptedAt(long attemptedAt) {
        this.attemptedAt = attemptedAt;
    }

    public String getPerformanceLevel() {
        if (percentage >= 90.0) {
            return "Excellent";
        } else if (percentage >= 75.0) {
            return "Very Good";
        } else if (percentage >= 50.0) {
            return "Good";
        } else {
            return "Needs Improvement";
        }
    }
}
