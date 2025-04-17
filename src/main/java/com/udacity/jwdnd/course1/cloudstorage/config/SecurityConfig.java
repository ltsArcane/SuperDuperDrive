package com.udacity.jwdnd.course1.cloudstorage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import com.udacity.jwdnd.course1.cloudstorage.services.AuthenticationService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final AuthenticationService authService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .formLogin(form -> form
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/chatroom", true))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/signup", "/favicon.ico", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated())
            .logout(logout -> logout
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/login?logout"))
            .authenticationProvider(authService)
            .build();
    }
}