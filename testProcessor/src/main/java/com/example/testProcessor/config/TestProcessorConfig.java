package com.example.testProcessor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class TestProcessorConfig {

    @Bean
    public Function<String, String> parseMessage() {
        return input -> {
            log.info("====== test processor =====");
            log.info("before message = {} ", input);
            String tmpMessage = input + " is parsed";
            log.info("parsed message = {} ", tmpMessage);
            return tmpMessage;
        };
    }

}
