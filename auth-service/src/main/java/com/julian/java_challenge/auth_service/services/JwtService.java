package com.julian.java_challenge.auth_service.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.java_challenge.auth_service.config.JwtConfig;
import com.julian.java_challenge.auth_service.model.User;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    @Autowired
    private JwtConfig jwtConfig;

    private SecretKey getSigningKey() {
        try {
            return Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes());
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtConfig.getExpiration());

        SecretKey signingKey = getSigningKey();

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("id", user.getId());

        return Jwts.builder().claims(claims).signWith(signingKey).expiration(expiryDate).compact();
    }

    public boolean validateToken(String token) {
        try {
            SecretKey signingKey = getSigningKey();

            Jwts.parser().verifyWith(signingKey).build().parseSignedClaims(token).getPayload();

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

}
