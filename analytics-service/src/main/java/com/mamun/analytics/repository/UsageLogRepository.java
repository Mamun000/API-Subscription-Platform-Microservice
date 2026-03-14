package com.mamun.analytics.repository;

import com.mamun.analytics.model.UsageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageLogRepository extends JpaRepository<UsageLog, Long> {
}