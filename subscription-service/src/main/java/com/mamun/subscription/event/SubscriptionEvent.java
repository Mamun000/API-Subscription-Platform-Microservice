package com.mamun.subscription.event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionEvent {

    private Long userId;
    private Long apiId;
    private String planType;

}