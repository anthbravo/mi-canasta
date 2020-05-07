package com.micanasta.repository;

import com.micanasta.model.Heartbeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartbeatRepository extends JpaRepository<Heartbeat, Long> {
}
