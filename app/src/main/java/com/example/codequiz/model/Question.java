package com.example.codequiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    private String id;
    private String category;
    private String difficulty; // Easy, Medium, Hard
    private String questionText;
    private List<String> options;
    private String correctAnswer;
    private String explanation;

    public Question() {
        this.options = new ArrayList<>();
    }

    public Question(String id, String category, String difficulty, String questionText,
                    List<String> options, String correctAnswer, String explanation) {
        this.id = id;
        this.category = category;
        this.difficulty = difficulty;
        this.questionText = questionText;
        this.options = options != null ? options : new ArrayList<>();
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
