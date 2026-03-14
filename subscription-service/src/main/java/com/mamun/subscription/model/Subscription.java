package com.mamun.subscription.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long apiId;

    private String apiKey;

    private String planType;

    private Integer requestLimit;

    private Integer requestsUsed;

    private LocalDateTime subscribedAt;

}