package com.movie.reviewapi;

import com.movie.reviewapi.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ReviewapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReviewapiApplication.class, args);
	}
}
