package com.example.testSource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@Configuration
public class TestSourceConfig {

    private String messages;

    @Bean
    public Supplier<String> sendMessage() {
        return () -> messages;
    }

    @GetMapping("/test")
    public ResponseEntity<?> testSourceInputData(@RequestParam(name = "sample") String received) {
        messages = received;
        return ResponseEntity.status(HttpStatus.OK).body("received");
    }

}