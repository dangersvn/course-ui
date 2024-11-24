package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.QuestionItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionItemRepository  extends MongoRepository<QuestionItem, String> {
}
