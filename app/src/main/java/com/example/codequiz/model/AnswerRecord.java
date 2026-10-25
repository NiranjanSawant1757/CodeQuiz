package com.example.codequiz.model;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnswerRecord implements Serializable {
    private long id;
    private long attemptId;
    private String questionId;
    private String questionText;
    private List<String> options;
    private String selectedAnswer;
    private String correctAnswer;
    private String explanation;
    private boolean isCorrect;
    private int questionOrder;

    public AnswerRecord() {
        this.options = new ArrayList<>();
    }

    public AnswerRecord(long id, long attemptId, String questionId, String questionText,
                        List<String> options, String selectedAnswer, String correctAnswer,
                        String explanation, boolean isCorrect, int questionOrder) {
        this.id = id;
        this.attemptId = attemptId;
        this.questionId = questionId;
        this.questionText = questionText;
        this.options = options != null ? options : new ArrayList<>();
        this.selectedAnswer = selectedAnswer;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
        this.isCorrect = isCorrect;
        this.questionOrder = questionOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(long attemptId) {
        this.attemptId = attemptId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public String getOptionsJson() {
        if (options == null || options.isEmpty()) {
            return "[]";
        }
        try {
            JSONArray jsonArray = new JSONArray();
            for (String opt : options) {
                jsonArray.put(opt);
            }
            String result = jsonArray.toString();
            if (result != null && !result.isEmpty()) {
                return result;
            }
        } catch (Throwable ignored) {
        }
        // Fallback for JVM unit tests where android.jar org.json is a stub
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < options.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append("\"").append(options.get(i).replace("\"", "\\\"")).append("\"");
        }
        sb.append("]");
        return sb.toString();
    }

    public void setOptionsFromJson(String json) {
        this.options = new ArrayList<>();
        if (json == null || json.trim().isEmpty()) return;
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                this.options.add(jsonArray.getString(i));
            }
            if (!this.options.isEmpty()) return;
        } catch (Throwable ignored) {
        }
        // Fallback parser for JVM unit tests
        String trimmed = json.trim();
        if (trimmed.startsWith("[") && trimmed.endsWith("]")) {
            String inner = trimmed.substring(1, trimmed.length() - 1);
            if (!inner.isEmpty()) {
                String[] parts = inner.split("\",\"");
                for (String part : parts) {
                    String clean = part.replaceAll("^\"|\"$", "").replace("\\\"", "\"");
                    this.options.add(clean);
                }
            }
        }
    }
}
