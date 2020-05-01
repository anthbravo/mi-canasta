package com.micanasta.repository;

import com.micanasta.model.Heartbeat;
import com.micanasta.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}