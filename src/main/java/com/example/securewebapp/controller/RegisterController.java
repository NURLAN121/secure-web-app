package com.example.securewebapp.controller;

import com.example.securewebapp.dto.CreateUserRequest;
import com.example.securewebapp.model.User;
import com.example.securewebapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository,
                              PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new CreateUserRequest());
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("user") CreateUserRequest req,
            BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }

        if (userRepository.existsByEmail(req.getEmail())) {
            result.rejectValue("email", "", "Email already exists");
            return "register";
        }

        User user = new User();
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return "redirect:/login";
    }
}
