package com.mamun.subscription.kafka;

import com.mamun.subscription.event.SubscriptionEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishSubscriptionEvent(SubscriptionEvent event) {

        String message = "User " + event.getUserId() +
                " subscribed to API " + event.getApiId();

        kafkaTemplate.send("subscription-created", message);

        System.out.println("Event sent to Kafka: " + message);
    }
}