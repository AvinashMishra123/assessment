package com.example.Assessment.service;

import com.example.Assessment.entity.DiscoveryResult;
import com.example.Assessment.entity.Job;
import com.example.Assessment.repository.DiscoveryResultRepository;
import com.example.Assessment.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DiscoveryService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private DiscoveryResultRepository discoveryResultRepository;

    @Async
    public String discoverServices(List<String> services) {
        // Asynchronously discover EC2 instances and S3 buckets
        // Save results in the database and return the JobId
        // ...

        String jobId = generateUniqueJobId();
        return jobId;
    }

    public String getJobResult(String jobId) {
        Optional<Job> optionalJob = jobRepository.findByJobId(jobId);
        return optionalJob.map(Job::getStatus).orElse("Job not found");
    }

    public List<String> getDiscoveryResult(String service) {
        List<DiscoveryResult> results = discoveryResultRepository.findByService(service);
        return results.stream().map(DiscoveryResult::getResult).collect(Collectors.toList());
    }

    @Async
    public String getS3BucketObjects(String bucketName) {
        // Asynchronously discover S3 bucket objects
        // Save results in the database and return the JobId
        // ...

        String jobId = generateUniqueJobId();
        return jobId;
    }

    public Integer getS3BucketObjectCount(String bucketName) {
        // Retrieve the count from the database based on the bucketName
        // ...

        return 0; // Placeholder, replace with actual logic
    }

    public List<String> getS3BucketObjectLike(String bucketName, String pattern) {
        // Retrieve file names matching the pattern from the database based on the bucketName
        // ...

        return Collections.emptyList(); // Placeholder, replace with actual logic
    }

    private String generateUniqueJobId() {
        // Generate a unique JobId (e.g., UUID.randomUUID().toString())
        return UUID.randomUUID().toString();
    }
}
