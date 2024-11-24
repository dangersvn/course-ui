package com.example.courses_management_service.dto;

public class RegisterResponse {
    private boolean success;
    private String userId; // Optional: Include if needed by the courses-service
    private String errorMessage;

    public RegisterResponse(boolean success, String userId, String errorMessage) {
        this.success = success;
        this.userId = userId;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
