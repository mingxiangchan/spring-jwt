package com.example.jwt.controllers;

import com.example.jwt.entities.User;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.security.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 */
@RestController
public class TestController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping(value = "/restricted")
    public String restricted() {
        return "{\"message\": \"This is restricted\"}";
    }

    @GetMapping(value = "/public")
    public String testPublic() {
        return "{\"message\": \"This is public\"}";
    }

    @GetMapping(value = "/currentUser")
    public User currentUser() {
        return userDetailsService.getCurrentUser();
    }
}