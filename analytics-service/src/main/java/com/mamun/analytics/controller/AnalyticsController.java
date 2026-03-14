package com.mamun.analytics.controller;

import com.mamun.analytics.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @PostMapping("/log")
    public void logUsage(
            @RequestParam Long apiId,
            @RequestParam Long userId,
            @RequestParam String apiKey,
            @RequestParam String endpoint
    ) {

        analyticsService.logUsage(apiId, userId, apiKey, endpoint);

    }
}