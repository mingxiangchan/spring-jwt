package com.example.jwt.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.entities.User;
import com.example.jwt.security.CustomUserPrincipal;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TestController
 */
@RestController
public class TestController {

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
        CustomUserPrincipal principal = (CustomUserPrincipal) auth.getPrincipal();
        return principal.getUser();
    }
}