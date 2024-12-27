package com.julian.java_challenge.auth_service.dto;

import com.julian.java_challenge.auth_service.model.User;

public class RegisterResponseDto {

    final private User user;
    final private String error;

    public RegisterResponseDto(User user, String error) {
        this.user = user;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public User getUser() {
        return user;
    }
}
