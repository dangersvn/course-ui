package com.example.courses_management_service.service;

import com.example.courses_management_service.model.AssessmentResult;

import java.util.List;

public interface AssessmentResultService {
    AssessmentResult saveAssessmentResult(AssessmentResult result);
    AssessmentResult getAssessmentResultById(String id);
    List<AssessmentResult> getAssessmentResultsByUser(String userId);
}
