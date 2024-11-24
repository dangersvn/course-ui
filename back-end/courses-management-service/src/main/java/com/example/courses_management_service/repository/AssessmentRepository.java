package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.Assessment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssessmentRepository extends MongoRepository<Assessment, String> {
}
