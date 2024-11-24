package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
    Enrollment getEnrollmentByUserIdAndCourseId(String userId, String courseId);
}
