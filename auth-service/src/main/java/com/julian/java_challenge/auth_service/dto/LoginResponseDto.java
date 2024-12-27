package com.julian.java_challenge.auth_service.dto;

public class LoginResponseDto {

    private String token;
    private String error;

    public LoginResponseDto(String token, String error) {
        this.token = token;
        this.error = error;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
