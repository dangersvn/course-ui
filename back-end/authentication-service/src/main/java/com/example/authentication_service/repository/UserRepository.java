package com.example.authentication_service.repository;

import com.example.authentication_service.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findById(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}