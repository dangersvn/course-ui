package com.example.courses_management_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("Assessment")
public class Assessment {
    @Id
    private String id;
    private String courseId;
    private String sectionId;
    private String subsectionId;
    private String title;
    private String description;
    private String type;
    private Integer timeLimit;
    private Integer passingScore;
    private List<QuestionItem> questions;  // Use a more specific name
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Assessment(String id, String courseId, LocalDateTime updatedAt, List<QuestionItem> questions, LocalDateTime createdAt, Integer passingScore, Integer timeLimit, String type, String description, String title, String subsectionId, String sectionId) {
        this.id = id;
        this.courseId = courseId;
        this.updatedAt = updatedAt;
        this.questions = questions;
        this.createdAt = createdAt;
        this.passingScore = passingScore;
        this.timeLimit = timeLimit;
        this.type = type;
        this.description = description;
        this.title = title;
        this.subsectionId = subsectionId;
        this.sectionId = sectionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
