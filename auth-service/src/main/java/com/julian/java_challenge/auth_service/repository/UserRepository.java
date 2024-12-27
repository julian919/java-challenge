package com.julian.java_challenge.auth_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.julian.java_challenge.auth_service.model.User;

// other projects could make use of the common auth module and keep its project's user to itself

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
