package com.example.courses_management_service.controller;


import com.example.courses_management_service.model.AssessmentResult;
import com.example.courses_management_service.service.AssessmentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/assessmentResults")
public class AssessmentResultController {

    @Autowired
    private AssessmentResultService assessmentResultService;




    @PostMapping
    public ResponseEntity<AssessmentResult> submitAssessmentResult(@RequestBody AssessmentResult assessmentResult) {
        AssessmentResult savedResult = assessmentResultService.saveAssessmentResult(assessmentResult);

        return ResponseEntity.created(URI.create("/api/assessmentResults/" + savedResult.getId())).body(savedResult);

    }
}
