package com.example.testProcessor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class testProcessorConfig {

    @Bean
    public Function<String, String> parseMessage() {
        return input -> input + " is parsed";
    }

}
