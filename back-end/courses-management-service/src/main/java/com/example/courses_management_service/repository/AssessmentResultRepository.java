package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.AssessmentResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssessmentResultRepository  extends MongoRepository<AssessmentResult, String> {
}
