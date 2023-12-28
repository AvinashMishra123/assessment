package com.example.Assessment.repository;

import com.example.Assessment.entity.DiscoveryResult;
import com.example.Assessment.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<Job> findByJobId(String jobId);

}
