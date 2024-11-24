package com.example.courses_management_service.service;

import com.example.courses_management_service.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollInCourse(String userId, String courseId);
    Enrollment getEnrollment(String userId, String courseId);
    List<Enrollment> getAllEnrollments();  // Might not be practical depending on data volume
    void updateEnrollmentStatus(String userId, String courseId, String status);
    void cancelEnrollment(String userId, String courseId);
}
