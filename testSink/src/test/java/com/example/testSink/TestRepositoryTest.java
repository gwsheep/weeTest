package com.example.testSink;


import com.example.testSink.entity.TestSample;
import com.example.testSink.repository.TestRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class TestRepositoryTest {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void 입력_테스트() {

        TestSample t1 = new TestSample();
        t1.setMessage("hello1");
        TestSample t2 = new TestSample();
        t2.setMessage("hello2");
        TestSample t3 = new TestSample();
        t3.setMessage("hello3");

        testRepository.save(t1);
        testRepository.save(t2);
        testRepository.save(t3);

        List<TestSample> sampleList = testRepository.findAll();
        String sample = sampleList.stream().filter(x -> x.getMessage().equals("hello1")).findFirst().get().getMessage();
        Assertions.assertThat("hello1").isEqualTo(sample);

    }

}
