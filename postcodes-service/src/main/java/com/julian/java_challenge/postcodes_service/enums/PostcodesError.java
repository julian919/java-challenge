package com.julian.java_challenge.postcodes_service.enums;

import org.springframework.http.HttpStatus;

public enum PostcodesError {
    POST_NOT_FOUND(HttpStatus.BAD_REQUEST, "POST_NOT_FOUND");

    private final HttpStatus code;
    private final String name;

    PostcodesError(HttpStatus code, String name) {
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
