package com.example.codequiz.model;

import java.io.Serializable;

public class QuizCategory implements Serializable {
    private String id;
    private String name;
    private String description;
    private int iconResId;
    private int questionCount;

    public QuizCategory(String id, String name, String description, int iconResId, int questionCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.iconResId = iconResId;
        this.questionCount = questionCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}
