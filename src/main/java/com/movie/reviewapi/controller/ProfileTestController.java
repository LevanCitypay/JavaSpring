package com.movie.reviewapi.controller;

import com.movie.reviewapi.config.AppProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileTestController {

    private final AppProperties appProperties;

    public ProfileTestController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/profile-info")
    @ResponseBody
    public String profile() {
        return "App Title: " + appProperties.getTitle() + "<br>" +
                "Message: " + appProperties.getMessage();
    }
}
