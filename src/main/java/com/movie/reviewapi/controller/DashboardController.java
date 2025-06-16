package com.movie.reviewapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class DashboardController {

    private final RestTemplate restTemplate;

    public DashboardController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/actuator/metrics")
    public String dashboard(Model model) {

        // Get memory usage from actuator
        Map memory = restTemplate.getForObject(
                "http://localhost:8080/actuator/metrics/jvm.memory.used", Map.class);

        // Get CPU usage from actuator
        Map cpu = restTemplate.getForObject(
                "http://localhost:8080/actuator/metrics/system.cpu.usage", Map.class);

        model.addAttribute("memory", memory);
        model.addAttribute("cpu", cpu);

        return "dashboard";
    }
}
