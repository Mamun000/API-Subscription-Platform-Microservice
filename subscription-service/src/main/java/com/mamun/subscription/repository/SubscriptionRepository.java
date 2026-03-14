package com.mamun.subscription.repository;

import com.mamun.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findByApiKey(String apiKey);


}