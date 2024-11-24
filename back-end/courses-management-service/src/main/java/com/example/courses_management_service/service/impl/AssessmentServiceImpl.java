package com.example.courses_management_service.service.impl;


import com.example.courses_management_service.model.Assessment;
import com.example.courses_management_service.repository.AssessmentRepository;
import com.example.courses_management_service.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;



    @Override
    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public Assessment getAssessmentById(String id) {
        return null;
    }

    @Override
    public List<Assessment> getAllAssessmentsByCourse(String courseId) {
        return List.of();
    }

    @Override
    public void updateAssessment(Assessment assessment) {

    }

    @Override
    public void deleteAssessment(String id) {

    }

}
