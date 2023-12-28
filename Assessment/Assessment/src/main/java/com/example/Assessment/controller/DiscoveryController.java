package com.example.Assessment.controller;

import com.example.Assessment.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class DiscoveryController {

    @Autowired
    private DiscoveryService discoveryService;

    @PostMapping("/discover")
    public ResponseEntity<String> discoverServices(@RequestBody List<String> services) {
        String jobId = discoveryService.discoverServices(services);
        return new ResponseEntity<>(jobId, HttpStatus.OK);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<String> getJobResult(@PathVariable String jobId) {
        String result = discoveryService.getJobResult(jobId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/discovery/{service}")
    public ResponseEntity<List<String>> getDiscoveryResult(@PathVariable String service) {
        List<String> result = discoveryService.getDiscoveryResult(service);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/s3/bucket/{bucketName}")
    public ResponseEntity<String> getS3BucketObjects(@PathVariable String bucketName) {
        String jobId = discoveryService.getS3BucketObjects(bucketName);
        return new ResponseEntity<>(jobId, HttpStatus.OK);
    }

    @GetMapping("/s3/bucket/{bucketName}/count")
    public ResponseEntity<Integer> getS3BucketObjectCount(@PathVariable String bucketName) {
        Integer count = discoveryService.getS3BucketObjectCount(bucketName);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/s3/bucket/{bucketName}/objects-like/{pattern}")
    public ResponseEntity<List<String>> getS3BucketObjectLike(
            @PathVariable String bucketName,
            @PathVariable String pattern) {
        List<String> matchingObjects = discoveryService.getS3BucketObjectLike(bucketName, pattern);
        return new ResponseEntity<>(matchingObjects, HttpStatus.OK);
    }
}
