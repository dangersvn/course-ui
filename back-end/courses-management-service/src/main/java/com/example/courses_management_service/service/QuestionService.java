package com.example.courses_management_service.service;

import com.example.courses_management_service.model.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);
    Question getQuestionById(String id);
    List<Question> getAllQuestionsByCourse(String courseId);
    void updateQuestion(Question question);
    void deleteQuestion(String id);
}
