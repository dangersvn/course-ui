package com.example.courses_management_service.service;

import com.example.courses_management_service.model.Assessment;

import java.util.List;

public interface AssessmentService {
    Assessment createAssessment(Assessment assessment);
    Assessment getAssessmentById(String id);
    List<Assessment> getAllAssessmentsByCourse(String courseId);
    void updateAssessment(Assessment assessment);
    void deleteAssessment(String id);
}
