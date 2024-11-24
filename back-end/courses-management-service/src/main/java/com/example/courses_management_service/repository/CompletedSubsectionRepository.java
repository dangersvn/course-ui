package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.CompletedSubsection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompletedSubsectionRepository extends MongoRepository<CompletedSubsection, String> {
}
