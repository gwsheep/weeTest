package com.example.testSink.config;

import com.example.testSink.entity.TestSample;
import com.example.testSink.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class TestSinkConfig {

    private final TestRepository testRepository;

    @Bean
    public Consumer<String> testConsumer() {

        return content -> {
            TestSample testSample = new TestSample();
            testSample.setMessage(content);
            testRepository.save(testSample);
        };

    }





}
