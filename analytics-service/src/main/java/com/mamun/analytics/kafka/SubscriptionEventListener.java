package com.mamun.analytics.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionEventListener {

    @KafkaListener(topics = "subscription-created", groupId = "analytics-group")
    public void consume(String message) {

        System.out.println("Received event from Kafka: " + message);

    }

}