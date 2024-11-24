package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.UserAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAnswerRepository  extends MongoRepository<UserAnswer, String> {
}
