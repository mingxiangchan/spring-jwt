package com.example.jwt.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.example.jwt.entities.User;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.security.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SignupController {
    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/signup")
    public Map<String, String> signup(@RequestBody User user) {
        repository.save(user);
        String token = JwtUtils.generateJwt(user);

        Map<String, String> body = new HashMap<>();
        body.put("token", token);

        return body;
    }

}