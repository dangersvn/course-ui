package com.example.courses_management_service.controller;

import com.example.courses_management_service.model.Enrollment;
import com.example.courses_management_service.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollment> enroll(@RequestBody Enrollment enrollment) { // Or use separate userId/courseId fields
        Enrollment createdEnrollment = enrollmentService.enrollInCourse(
                enrollment.getUserId(), enrollment.getCourseId());
        return ResponseEntity.created(URI.create("/api/enrollments" + createdEnrollment.getId())).body(createdEnrollment); // Consider a more relevant location

    }
}
