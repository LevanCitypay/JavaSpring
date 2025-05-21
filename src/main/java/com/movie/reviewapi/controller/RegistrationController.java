package com.movie.reviewapi.controller;

import com.movie.reviewapi.model.User;
import com.movie.reviewapi.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository,
                                  BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    @Operation(summary = "Show registration form")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    @Operation(summary = "Process registration and save user to DB securely")
    public String processRegistration(@RequestParam String username,
                                      @RequestParam String email,
                                      @RequestParam String password,
                                      Model model) {

        // Check if email is already used
        if (userRepository.existsByEmail(email)) {
            model.addAttribute("success", "❌ Email is already in use.");
            return "registration";
        }

        // Create new user and save
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // ✅ Encrypted password

        userRepository.save(user);

        model.addAttribute("success", "✅ Registration successful! You can now log in.");
        return "registration";
    }
}
