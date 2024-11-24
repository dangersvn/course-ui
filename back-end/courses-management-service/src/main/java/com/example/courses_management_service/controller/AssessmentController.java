package com.example.courses_management_service.controller;

import com.example.courses_management_service.model.Assessment;
import com.example.courses_management_service.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {


    @Autowired
    private AssessmentService assessmentService;


    @PostMapping
    public ResponseEntity<Assessment> createAssessment(@RequestBody Assessment assessment) {
        Assessment createdAssessment = assessmentService.createAssessment(assessment);

        return ResponseEntity.created(URI.create("/api/assessments/" + createdAssessment.getId())).body(createdAssessment);

    }
}