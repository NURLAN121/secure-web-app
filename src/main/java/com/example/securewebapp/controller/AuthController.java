package com.example.securewebapp.controller;

import com.example.securewebapp.dto.CreateUserRequest;
import com.example.securewebapp.model.User;
import com.example.securewebapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody CreateUserRequest req) {

        if (userRepository.existsByEmail(req.getEmail())) {
            return "EMAIL_EXISTS";
        }

        User user = new User();
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);
        return "OK";
    }
}
