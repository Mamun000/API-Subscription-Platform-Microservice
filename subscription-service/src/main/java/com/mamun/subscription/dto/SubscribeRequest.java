package com.mamun.subscription.dto;

import lombok.Data;

@Data
public class SubscribeRequest {

    private Long userId;

    private Long apiId;

    private String planType;

}