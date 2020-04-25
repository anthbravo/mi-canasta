package com.micanasta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micanasta.model.Heartbeat;

public interface HeartbeatRepository extends JpaRepository<Heartbeat, Long> {

}
