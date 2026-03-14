package com.mamun.analytics.service;

import com.mamun.analytics.model.UsageLog;
import com.mamun.analytics.repository.UsageLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final UsageLogRepository repository;

    public void logUsage(Long apiId, Long userId, String apiKey, String endpoint) {

        UsageLog log = UsageLog.builder()
                .apiId(apiId)
                .userId(userId)
                .apiKey(apiKey)
                .endpoint(endpoint)
                .requestTime(LocalDateTime.now())
                .build();

        repository.save(log);
    }
}