package com.example.Assessment.repository;

import com.example.Assessment.entity.DiscoveryResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscoveryResultRepository extends JpaRepository<DiscoveryResult, Long> {
    List<DiscoveryResult> findByService(String service);
}
