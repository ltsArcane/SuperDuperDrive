package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.ArrayList;

import com.udacity.jwdnd.course1.cloudstorage.models.User;

import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService implements AuthenticationProvider {
    private UserService userService;
    private HashService hashService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.findUserByUsername(username);
        if (user != null) {
            String encodedSalt = user.getSalt();
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (user.getPassword().equals(hashedPassword)) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }
        // If no user, or pass mismatch, throw error (not yet used; must configure AuthenticationFailureHandler)
        throw new BadCredentialsException("Invalid username or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}