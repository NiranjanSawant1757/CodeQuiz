package com.example.codequiz.model;

import java.io.Serializable;
import java.util.List;

public class DashboardStats implements Serializable {
    private int totalQuizzes;
    private int totalQuestions;
    private double averageScore;
    private double highestScore;
    private String strongestCategory;
    private String categoryNeedingImprovement;
    private String recentImprovementText;
    private double recentImprovementPoints;
    private List<CategoryPerformance> categoryPerformances;
    private List<QuizAttempt> recentAttempts;

    public DashboardStats() {
    }

    public int getTotalQuizzes() {
        return totalQuizzes;
    }

    public void setTotalQuizzes(int totalQuizzes) {
        this.totalQuizzes = totalQuizzes;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public double getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(double highestScore) {
        this.highestScore = highestScore;
    }

    public String getStrongestCategory() {
        return strongestCategory;
    }

    public void setStrongestCategory(String strongestCategory) {
        this.strongestCategory = strongestCategory;
    }

    public String getCategoryNeedingImprovement() {
        return categoryNeedingImprovement;
    }

    public void setCategoryNeedingImprovement(String categoryNeedingImprovement) {
        this.categoryNeedingImprovement = categoryNeedingImprovement;
    }

    public String getRecentImprovementText() {
        return recentImprovementText;
    }

    public void setRecentImprovementText(String recentImprovementText) {
        this.recentImprovementText = recentImprovementText;
    }

    public double getRecentImprovementPoints() {
        return recentImprovementPoints;
    }

    public void setRecentImprovementPoints(double recentImprovementPoints) {
        this.recentImprovementPoints = recentImprovementPoints;
    }

    public List<CategoryPerformance> getCategoryPerformances() {
        return categoryPerformances;
    }

    public void setCategoryPerformances(List<CategoryPerformance> categoryPerformances) {
        this.categoryPerformances = categoryPerformances;
    }

    public List<QuizAttempt> getRecentAttempts() {
        return recentAttempts;
    }

    public void setRecentAttempts(List<QuizAttempt> recentAttempts) {
        this.recentAttempts = recentAttempts;
    }
}
