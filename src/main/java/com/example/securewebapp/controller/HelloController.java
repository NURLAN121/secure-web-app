package com.example.securewebapp.controller;

import com.example.securewebapp.dto.CreateUserRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * Simple GET endpoint
     * URL: GET /hello
     * Response: 200 OK, plain text
     */
    @GetMapping("/hello")
    public String hello() {
        return "OK";
    }

    /**
     * Header handling example
     * URL: GET /agent
     * Header: User-Agent
     * Response: 200 OK, plain text
     */
    @GetMapping("/agent")
    public String agent(@RequestHeader("User-Agent") String userAgent) {
        return "Your User-Agent is: " + userAgent;
    }

    /**
     * POST endpoint with JSON body + validation
     * URL: POST /users
     * Consumes: application/json
     * Produces: application/json
     *
     * Responses:
     * 200 OK - valid request
     * 400 Bad Request - validation error
     * 415 Unsupported Media Type - wrong Content-Type
     */
    @PostMapping(
            value = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String createUser(@Valid @RequestBody CreateUserRequest request) {
        return "User created: " + request.getUsername();
    }
}
