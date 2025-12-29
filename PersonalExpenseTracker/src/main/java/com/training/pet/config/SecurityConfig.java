package com.training.pet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for APIs
                .csrf(csrf -> csrf.disable())

                // Secure all endpoints
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )

                // Enable Basic Auth
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
