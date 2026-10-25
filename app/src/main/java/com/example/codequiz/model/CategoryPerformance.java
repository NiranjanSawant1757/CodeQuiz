package com.example.codequiz.model;

import java.io.Serializable;

public class CategoryPerformance implements Serializable {
    private String category;
    private int attemptsCount;
    private double averagePercentage;
    private double highestPercentage;

    public CategoryPerformance(String category, int attemptsCount, double averagePercentage, double highestPercentage) {
        this.category = category;
        this.attemptsCount = attemptsCount;
        this.averagePercentage = averagePercentage;
        this.highestPercentage = highestPercentage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsCount(int attemptsCount) {
        this.attemptsCount = attemptsCount;
    }

    public double getAveragePercentage() {
        return averagePercentage;
    }

    public void setAveragePercentage(double averagePercentage) {
        this.averagePercentage = averagePercentage;
    }

    public double getHighestPercentage() {
        return highestPercentage;
    }

    public void setHighestPercentage(double highestPercentage) {
        this.highestPercentage = highestPercentage;
    }
}
