package com.example.courses_management_service.model;

import java.time.LocalDateTime;

public class Note {
    private String subsectionId;
    private String content;
    private LocalDateTime createdAt;

    public Note(String subsectionId, LocalDateTime createdAt, String content) {
        this.subsectionId = subsectionId;
        this.createdAt = createdAt;
        this.content = content;
    }

    public String getSubsectionId() {
        return subsectionId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setSubsectionId(String subsectionId) {
        this.subsectionId = subsectionId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
