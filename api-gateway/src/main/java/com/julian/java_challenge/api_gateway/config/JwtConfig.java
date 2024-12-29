package com.julian.java_challenge.api_gateway.config;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtConfig {

    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public SecretKey getSigningKey() {
        try {
            return Keys.hmacShaKeyFor(secret.getBytes());
        } catch (RuntimeException e) {
            throw e;
        }
    }

}
