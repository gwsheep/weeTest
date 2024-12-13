package com.example.testSink.repository;

import com.example.testSink.entity.TestSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestSample, Long> {
}
