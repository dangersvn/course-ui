package com.example.courses_management_service.repository;

import com.example.courses_management_service.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<UserEntity, String> {
}
