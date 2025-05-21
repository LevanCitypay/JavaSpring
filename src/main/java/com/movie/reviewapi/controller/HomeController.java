package com.movie.reviewapi.controller;

import com.movie.reviewapi.config.AppProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final AppProperties appProperties;

    public HomeController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/profile")
    @ResponseBody
    public String showProfileInfo() {
        return "App Title: " + appProperties.getTitle() + "<br>" +
                "Message: " + appProperties.getMessage();
    }
}
