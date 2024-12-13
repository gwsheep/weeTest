package com.example.testSink.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
@RequiredArgsConstructor
public class TestSinkController {

    private final Consumer<Message<>> testConsumer;



    //sink에서 먼저 test해보기
    //rabbitMQ prefetch 1로 변경해서 진행하기


}
