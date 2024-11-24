package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgressRepository extends MongoRepository<Progress, String> {
}
