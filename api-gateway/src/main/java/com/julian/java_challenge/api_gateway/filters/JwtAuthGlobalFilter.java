package com.julian.java_challenge.api_gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.julian.java_challenge.api_gateway.config.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthGlobalFilter implements GlobalFilter, Ordered {

    private final JwtConfig jwtConfig;

    public JwtAuthGlobalFilter(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String token = headers.getFirst(HttpHeaders.AUTHORIZATION);

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Remove "Bearer " prefix

            try {
                // Validate and parse the token
                Claims claims = Jwts.parser()
                        .verifyWith(jwtConfig.getSigningKey()).build() // Use your secret key
                        .parseSignedClaims(token)
                        .getPayload();

                String userId = claims.get("id", String.class); // Extract user ID
                String username = claims.get("username", String.class); // Extract username

                System.out.println("my username" + username);
                System.out.println("my user id" + userId);
                // Add claims to headers for downstream services
                exchange = mutateRequest(exchange, username, userId);

                return chain.filter(exchange);
            } catch (RuntimeException e) {
                // Log invalid token and proceed without modifying the request
                System.out.println("Invalid JWT Token: " + e.getMessage());
            }
        }

        return chain.filter(exchange);
    }

    private ServerWebExchange mutateRequest(ServerWebExchange exchange, String username, String userId) {
        return exchange.mutate()
                .request(builder -> builder
                        .header("X-Username", username)
                        .header("X-User-Id", userId))
                .build();
    }

    @Override
    public int getOrder() {
        return -1; // High precedence for this filter
    }
}