package com.example.courses_management_service.service.impl;


import com.example.courses_management_service.model.Question;
import com.example.courses_management_service.repository.QuestionRepository;
import com.example.courses_management_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question createQuestion(Question question) {

        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById(String id) {
        return null;
    }

    @Override
    public List<Question> getAllQuestionsByCourse(String courseId) {
        return List.of();
    }

    @Override
    public void updateQuestion(Question question) {

    }

    @Override
    public void deleteQuestion(String id) {

    }
}
