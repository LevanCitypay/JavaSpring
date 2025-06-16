package com.movie.reviewapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome"; // corresponds to welcome.html in src/main/resources/templates
    }
}
