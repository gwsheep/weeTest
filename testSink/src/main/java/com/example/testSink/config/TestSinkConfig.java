package com.example.testSink.config;

import com.example.testSink.entity.TestSample;
import com.example.testSink.repository.TestRepository;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@Slf4j
@Configuration
@RestController
@RequiredArgsConstructor
public class TestSinkConfig {

    private final TestRepository testRepository;

    @Bean
    public Consumer<Message<String>> testConsumer() {

        return content -> {
            
            log.info("====== test sink =====");

            TestSample testSample = new TestSample();
            testSample.setMessage(content.getPayload());

            System.out.println("content.getHeaders() = " + content.getHeaders());
            System.out.println("content.getPayload() = " + content.getPayload());
            System.out.println("content.getClass() = " + content.getClass());

            //            testRepository.save(testSample);

//            Channel channel = content.getHeaders().get("amqp_channel", Channel.class);
        };
    }

    @GetMapping("/tester")
    public ResponseEntity<String> 테스트용(@RequestParam("con") String con) {


        this.testConsumer();

        return ResponseEntity.status(HttpStatus.OK).body();
    }







}
