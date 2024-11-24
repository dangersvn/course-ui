package com.example.courses_management_service.model;

public class UserAnswer {
    private String questionId;
    private Object answer;  // Use Object to handle various answer types
    private Boolean isCorrect;
    private Integer points;

    public UserAnswer(String questionId, Object answer, Boolean isCorrect, Integer points) {
        this.questionId = questionId;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.points = points;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
