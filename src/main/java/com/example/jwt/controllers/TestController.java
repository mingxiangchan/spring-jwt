package com.example.jwt.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.entities.User;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.security.CustomUserPrincipal;
import com.example.jwt.services.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TestController
 */
@RestController
public class TestController {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/restricted")
    public String restricted() {
        return "{\"message\": \"This is restricted\"}";
    }

    @GetMapping(value = "/public")
    public String testPublic() {
        return "{\"message\": \"This is public\"}";
    }

    @GetMapping(value = "/currentUser")
    public User currentUser(Authentication auth) {
        String currentUserId = (String) auth.getPrincipal();
        User currentUser = repository.findById(Long.parseLong(currentUserId)).orElse(null);
        return currentUser;
    }
}