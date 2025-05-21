package com.movie.reviewapi.config;

import com.movie.reviewapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileBasedConfig {

    @Bean
    @Profile("dev")
    public CommandLineRunner devData(UserRepository repo) {
        return args -> {
            System.out.println("🚀 Running dev init...");
            // repo.save(... test data);
        };
    }

    @Bean
    @Profile("prod")
    public CommandLineRunner prodInit() {
        return args -> {
            System.out.println("🔒 Production boot initialized.");
        };
    }
}

