package com.example.courses_management_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("Enrollment")
public class Enrollment {
    @Id
    private String id;
    private String userId;
    private String courseId;
    private LocalDateTime enrolledAt;
    private String status;
    private LocalDateTime completedAt;
    private Progress progress;
    private List<Note> notes;
    private List<String> bookmarks;

    public Enrollment(String id, String userId, String courseId, LocalDateTime enrolledAt, String status, LocalDateTime completedAt, Progress progress, List<Note> notes, List<String> bookmarks) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.enrolledAt = enrolledAt;
        this.status = status;
        this.completedAt = completedAt;
        this.progress = progress;
        this.notes = notes;
        this.bookmarks = bookmarks;
    }

    public Enrollment() {

    }

    public void setUserId(String userId) {
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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<String> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<String> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
