package com.example.courses_management_service.service;

import com.example.courses_management_service.model.UserEntity;

public interface UserService {
    UserEntity getUserById(String id);
}
