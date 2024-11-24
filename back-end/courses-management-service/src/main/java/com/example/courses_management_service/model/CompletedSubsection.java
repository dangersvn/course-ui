package com.example.courses_management_service.model;

import java.time.LocalDateTime;

public class CompletedSubsection {
    private String subsectionId;
    private LocalDateTime completedAt;

    public CompletedSubsection(String subsectionId, LocalDateTime completedAt) {
        this.subsectionId = subsectionId;
        this.completedAt = completedAt;
    }

    public String getSubsectionId() {
        return subsectionId;
    }

    public void setSubsectionId(String subsectionId) {
        this.subsectionId = subsectionId;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
