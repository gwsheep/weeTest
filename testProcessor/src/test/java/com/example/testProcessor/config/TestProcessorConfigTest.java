package com.example.testProcessor.config;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
public class TestProcessorConfigTest {

    @Autowired
    private Function<String, String> parseMessage;

    @Test
    public void configTest() {

        String str = parseMessage.apply("testMessage");
        System.out.println("str = " + str);
        Assertions.assertThat("testMessage is parsed").isEqualTo(str);

    }



}
