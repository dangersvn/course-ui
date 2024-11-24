package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer, String> {
}
