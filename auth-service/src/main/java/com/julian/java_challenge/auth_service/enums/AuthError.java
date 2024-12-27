package com.julian.java_challenge.auth_service.enums;

import org.springframework.http.HttpStatus;

public enum AuthError {
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "WRONG_PASSWORD"),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "USER_ALREADY_EXISTS");

    private final HttpStatus code;
    private final String name;

    AuthError(HttpStatus code, String name) {
        this.code = code;
        this.name = name;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
