package com.julian.java_challenge.auth_service.services;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.julian.java_challenge.auth_service.dto.LoginRequestDto;
import com.julian.java_challenge.auth_service.dto.RegisterRequestDto;
import com.julian.java_challenge.auth_service.enums.AuthError;
import com.julian.java_challenge.auth_service.model.User;
import com.julian.java_challenge.auth_service.repository.UserRepository;

@Service
public class AuthService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(JwtService jwtService, UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String authenticate(LoginRequestDto loginRequestDto) {
        String username = loginRequestDto.getUsername();

        User user = userRepository.findByUsername(username);
        if (user == null) {
            // Dont want to give info that the user is registered or not so throw wrong
            // password error
            throw new RuntimeException(AuthError.WRONG_PASSWORD.getName());
        }

        boolean isValid = bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), user.getPassword());

        if (!isValid) {
            throw new RuntimeException(AuthError.WRONG_PASSWORD.getName());
        }

        return jwtService.generateToken(user);

    }

    public User createUser(RegisterRequestDto registerRequestDto) {
        String hashedPassword = bCryptPasswordEncoder.encode(registerRequestDto.getPassword());
        User user = new User(registerRequestDto.getUsername(), hashedPassword);

        try {
            return userRepository.save(user);
        } catch (DuplicateKeyException e) {
            throw new RuntimeException(AuthError.USER_ALREADY_EXISTS.getName());
        }

    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
