package com.example.courses_management_service.service;

import com.example.courses_management_service.demo.activemq.demopointtopoint.QueuePointToPointService;
import com.example.courses_management_service.demo.activemq.demotopic.TopicBroadcastService;
import com.example.courses_management_service.model.Course;
import com.example.courses_management_service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private QueuePointToPointService queuePointToPointService;
    @Autowired
    private TopicBroadcastService topicBroadcastService;

    public List<Course> getAllCourses() {
        this.queuePointToPointService.demonstratePointToPoint();
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        topicBroadcastService.demonstrateBroadcast();
        return courseRepository.save(course);
    }

    public Course updateCourse(String id, Course course) {
        course.setId(id);
        return courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
