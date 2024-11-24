package com.example.courses_management_service.model;

import java.time.LocalDateTime;
import java.util.List;

public class Progress{
    private Integer overallProgress;
    private LocalDateTime lastAccessedAt;
    private String lastAccessedSection;
    private String lastAccessedSubsection;
    private List<CompletedSubsection> completedSubsections;

    public Progress(Integer overallProgress, LocalDateTime lastAccessedAt, String lastAccessedSection, String lastAccessedSubsection, List<CompletedSubsection> completedSubsections) {
        this.overallProgress = overallProgress;
        this.lastAccessedAt = lastAccessedAt;
        this.lastAccessedSection = lastAccessedSection;
        this.lastAccessedSubsection = lastAccessedSubsection;
        this.completedSubsections = completedSubsections;
    }

    public Integer getOverallProgress() {
        return overallProgress;
    }

    public void setOverallProgress(Integer overallProgress) {
        this.overallProgress = overallProgress;
    }

    public LocalDateTime getLastAccessedAt() {
        return lastAccessedAt;
    }

    public void setLastAccessedAt(LocalDateTime lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
    }

    public String getLastAccessedSection() {
        return lastAccessedSection;
    }

    public void setLastAccessedSection(String lastAccessedSection) {
        this.lastAccessedSection = lastAccessedSection;
    }

    public String getLastAccessedSubsection() {
        return lastAccessedSubsection;
    }

    public void setLastAccessedSubsection(String lastAccessedSubsection) {
        this.lastAccessedSubsection = lastAccessedSubsection;
    }

    public List<CompletedSubsection> getCompletedSubsections() {
        return completedSubsections;
    }

    public void setCompletedSubsections(List<CompletedSubsection> completedSubsections) {
        this.completedSubsections = completedSubsections;
    }
}
