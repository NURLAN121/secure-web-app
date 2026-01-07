package com.example.securewebapp.controller;

import com.example.securewebapp.dto.CreateUserRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "OK";
    }

    // HEADER
    @GetMapping("/agent")
    public String agent(@RequestHeader("User-Agent") String userAgent) {
        return "Your User-Agent is: " + userAgent;
    }

    // BODY + VALIDATION
    @PostMapping("/users")
    public String createUser(@Valid @RequestBody CreateUserRequest request) {
        return "User created: " + request.getUsername();
    }
}
