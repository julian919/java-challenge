package com.julian.java_challenge.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
        @Bean
        public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
                return builder.routes()
                                .route(p -> p.path("/postcodes/**")
                                                .uri("lb://postcodes-service"))
                                .route(p -> p.path("/auth/**")
                                                .uri("lb://auth-service"))
                                .build();
        }

}
