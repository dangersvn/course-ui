package com.example.courses_management_service.service.impl;

import com.example.courses_management_service.model.AssessmentResult;
import com.example.courses_management_service.repository.AssessmentResultRepository;
import com.example.courses_management_service.service.AssessmentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentResultServiceImpl implements AssessmentResultService {

    @Autowired
    private AssessmentResultRepository assessmentResultRepository;



    @Override
    public AssessmentResult saveAssessmentResult(AssessmentResult result) {
        return assessmentResultRepository.save(result);
    }

    @Override
    public AssessmentResult getAssessmentResultById(String id) {
        return null;
    }

    @Override
    public List<AssessmentResult> getAssessmentResultsByUser(String userId) {
        return List.of();
    }
}
