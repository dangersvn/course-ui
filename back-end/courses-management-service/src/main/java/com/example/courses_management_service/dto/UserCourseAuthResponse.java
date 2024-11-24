package com.example.courses_management_service.dto;

import java.util.List;

public class UserCourseAuthResponse {
    private boolean authenticated; // Or isValid, hasAccess, etc.
    private String userId;
    private String username; // If needed by courses-service
    private List<String> roles; // User roles for authorization
    private List<String> enrolledCourses; //  (Optional) List of course IDs user is enrolled in
    private String errorMessage;

    public UserCourseAuthResponse(boolean authenticated, String userId, String username, List<String> roles, List<String> enrolledCourses, String errorMessage) {
        this.authenticated = authenticated;
        this.userId = userId;
        this.username = username;
        this.roles = roles;
        this.enrolledCourses = enrolledCourses;
        this.errorMessage = errorMessage;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
