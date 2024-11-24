package com.example.courses_management_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("AssessmentResult")
public class AssessmentResult {
    @Id
    private String id;
    private String userId;
    private String assessmentId;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private Integer score;
    private List<UserAnswer> answers;
    private String feedback;

    public AssessmentResult(String id, String userId, String assessmentId, LocalDateTime startedAt, LocalDateTime completedAt, Integer score, List<UserAnswer> answers, String feedback) {
        this.id = id;
        this.userId = userId;
        this.assessmentId = assessmentId;
        this.startedAt = startedAt;
        this.completedAt = completedAt;
        this.score = score;
        this.answers = answers;
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<UserAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<UserAnswer> answers) {
        this.answers = answers;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
