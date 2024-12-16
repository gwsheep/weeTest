package com.example.testSink.config;

import com.example.testSink.entity.TestSample;
import com.example.testSink.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.StaticMessageHeaderAccessor;
import org.springframework.integration.acks.AcknowledgmentCallback;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TestSinkConfig {

    private final TestRepository testRepository;

    @Bean
    public Consumer<Message<String>> testConsumer() {

        log.info("====== test sink =====");

        return content -> {

            AcknowledgmentCallback acknowledgmentCallback = StaticMessageHeaderAccessor.getAcknowledgmentCallback(content);

            try {
                TestSample testSample = new TestSample();
                testSample.setMessage(content.getPayload());
                testRepository.save(testSample);
                log.info("=== message saved ===");
                if (acknowledgmentCallback != null) {
                    acknowledgmentCallback.acknowledge(AcknowledgmentCallback.Status.ACCEPT);
                    log.info("message = {} ", content.getPayload());
                }
            } catch (Exception e) {
                if(acknowledgmentCallback != null) {
                    acknowledgmentCallback.acknowledge(AcknowledgmentCallback.Status.REJECT);
                    log.info("message rejected");
                }
            }

        };
    }

}
