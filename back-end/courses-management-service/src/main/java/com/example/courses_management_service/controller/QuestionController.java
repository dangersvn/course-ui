package com.example.courses_management_service.controller;


import com.example.courses_management_service.model.Question;
import com.example.courses_management_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {


    @Autowired
    private QuestionService questionService;


    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {

        Question createdQuestion = questionService.createQuestion(question);

        return ResponseEntity.created(URI.create("/api/questions/" + createdQuestion.getId())).body(createdQuestion);
    }
}