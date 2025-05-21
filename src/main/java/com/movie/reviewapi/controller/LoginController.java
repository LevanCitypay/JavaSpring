package com.movie.reviewapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    @Operation(summary = "Show login form")
    public String showLoginForm() {
        return "login"; // templates/login.html
    }
}
