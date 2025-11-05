package com.devv.smartSheduling.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS configuration class.
 * <p>
 * This class allows cross-origin requests from frontend applications.
 * It is used to avoid errors when frontend calls backend APIs from another origin.
 * </p>
 */
@Configuration
public class CorsConfig {

    /**
     * WebMvcConfigurer bean to configure CORS.
     * <p>
     * Sets allowed origins, methods, headers, and credentials for all endpoints.
     * </p>
     *
     * @return a configured WebMvcConfigurer instance

     * Add CORS mappings.
     * <p>
     * Allows all endpoints to be accessed from specific frontend URLs.
     * </p>
     *
     * @param registry the CorsRegistry to configure
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:5173",
                                "http://127.0.0.1:5173",
                                "https://mi-frontend.com"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
