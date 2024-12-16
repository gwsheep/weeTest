package com.example.testSource.config;

import com.example.testSource.entity.TestSample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@Slf4j
@RestController
@Configuration
public class TestSourceConfig {

    private String messages;

    @Bean
    public Supplier<String> sendMessage() {
        return () -> {
            if (messages != null) {
                String tempMessage = messages;
                messages = null;
                return tempMessage;
            }
            return null;
        };
    }

    @PostMapping("/test")
    public ResponseEntity<?> testSourceInputData(@RequestBody TestSample testSample) {

        log.info("====== test source =====");
        messages = testSample.getMessage();
        log.info("message = {}", messages);
        return ResponseEntity.status(HttpStatus.OK).body("received");

    }

}