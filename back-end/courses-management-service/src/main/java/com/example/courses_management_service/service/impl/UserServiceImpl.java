package com.example.courses_management_service.service.impl;

import com.example.courses_management_service.model.UserEntity;
import com.example.courses_management_service.repository.UserRepository;
import com.example.courses_management_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserById(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.orElse(null); // Or throw an exception if not found
    }

}
