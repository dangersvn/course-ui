package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.Section;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectionRepository extends MongoRepository<Section, String> {
}
