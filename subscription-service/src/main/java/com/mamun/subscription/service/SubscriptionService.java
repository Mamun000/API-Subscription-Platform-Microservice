package com.mamun.subscription.service;

import com.mamun.subscription.dto.SubscribeRequest;
import com.mamun.subscription.dto.SubscribeResponse;
import com.mamun.subscription.event.SubscriptionEvent;
import com.mamun.subscription.model.Subscription;
import com.mamun.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final KafkaTemplate<String, SubscriptionEvent> kafkaTemplate;

    public SubscribeResponse subscribe(SubscribeRequest request) {

        String apiKey = UUID.randomUUID().toString();

        Subscription subscription = Subscription.builder()
                .userId(request.getUserId())
                .apiId(request.getApiId())
                .apiKey(apiKey)
                .planType(request.getPlanType())
                .requestLimit(1000)
                .requestsUsed(0)
                .subscribedAt(LocalDateTime.now())
                .build();

        subscriptionRepository.save(subscription);

        return new SubscribeResponse(apiKey);
    }

}