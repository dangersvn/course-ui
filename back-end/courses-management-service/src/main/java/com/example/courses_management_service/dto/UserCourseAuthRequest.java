package com.example.courses_management_service.dto;

public class UserCourseAuthRequest {
    private String userId; // Or token, depending on your authentication strategy
    private String courseId; // If you need course-specific authorization

    public UserCourseAuthRequest(String userId, String courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
