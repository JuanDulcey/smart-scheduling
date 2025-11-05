package com.devv.smartSheduling.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class.
 * <p>
 * This class configures basic security settings for the application.
 * It can be extended to add authentication and authorization rules.
 * </p>
 */
@Configuration
public class SecurityConfig {

    /**
     * Configure the security filter chain.
     * <p>
     * Currently, CSRF protection is disabled and all requests are allowed.
     * You can customize this to require authentication or specific roles for endpoints.
     * </p>
     *
     * @param http the HttpSecurity object to configure
     * @return a configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}

