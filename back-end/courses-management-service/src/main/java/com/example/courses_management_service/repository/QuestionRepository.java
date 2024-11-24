package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}
