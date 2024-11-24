package com.example.courses_management_service.service.impl;


import com.example.courses_management_service.model.Enrollment;
import com.example.courses_management_service.repository.CourseRepository;
import com.example.courses_management_service.repository.EnrollmentRepository;
import com.example.courses_management_service.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;


    @Autowired
    private CourseRepository courseRepository; // Assuming you need to access course details

    @Override
    public Enrollment enrollInCourse(String userId, String courseId) {
        // Check if the course and user exists first for proper error handling

        Enrollment enrollment = new Enrollment();
        enrollment.setUserId(userId);
        enrollment.setCourseId(courseId);
        // ... set other enrollment properties ...
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment getEnrollment(String userId, String courseId) {
        return enrollmentRepository.getEnrollmentByUserIdAndCourseId(userId,courseId);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public void updateEnrollmentStatus(String userId, String courseId, String status) {

    }

    @Override
    public void cancelEnrollment(String userId, String courseId) {

    }
}
