package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class MetricsFetchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsFetchDemoApplication.class, args);
	}
}
