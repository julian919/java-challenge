package com.julian.java_challenge.auth_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.julian.java_challenge.auth_service.dto.LoginRequestDto;
import com.julian.java_challenge.auth_service.dto.LoginResponseDto;
import com.julian.java_challenge.auth_service.dto.RegisterRequestDto;
import com.julian.java_challenge.auth_service.dto.RegisterResponseDto;
import com.julian.java_challenge.auth_service.model.User;
import com.julian.java_challenge.auth_service.services.AuthService;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            String token = authService.authenticate(loginRequestDto);
            LoginResponseDto successResponse = new LoginResponseDto(token, null);
            return ResponseEntity.ok(successResponse);

        } catch (RuntimeException e) {
            LoginResponseDto errorResponse = new LoginResponseDto(null, e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    // Real world , should move this to a new user microservice
    @PostMapping("/user")
    public List<User> retrieveUser(@RequestBody Map<String, String> requestBody) {
        return authService.getUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        try {
            User user = authService.createUser(registerRequestDto);
            RegisterResponseDto successResponse = new RegisterResponseDto(user, null);
            return ResponseEntity.ok(successResponse);
        } catch (RuntimeException e) {
            RegisterResponseDto errorResponse = new RegisterResponseDto(null, e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);

        }

    }
}
