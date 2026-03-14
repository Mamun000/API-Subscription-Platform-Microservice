package com.mamun.subscription.controller;

import com.mamun.subscription.dto.SubscribeRequest;
import com.mamun.subscription.dto.SubscribeResponse;
import com.mamun.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public SubscribeResponse subscribe(@RequestBody SubscribeRequest request) {
        return subscriptionService.subscribe(request);
    }

}