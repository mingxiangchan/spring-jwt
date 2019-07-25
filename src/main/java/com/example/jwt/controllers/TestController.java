package com.example.jwt.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * TestController
 */
@RestController
public class TestController {

    @GetMapping(value="/restricted")
    public String restricted() {
        return "{\"message\": \"This is restricted\"}";
    }    

    @GetMapping(value="/public")
    public String testPublic() {
        return "{\"message\": \"This is public\"}";
    }    
}