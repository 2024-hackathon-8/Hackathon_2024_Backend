package com.example.hackathon_2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Hackathon2024Application {

    public static void main(String[] args) {
        SpringApplication.run(Hackathon2024Application.class, args);
    }

}
