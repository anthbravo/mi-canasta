package com.micanasta.repository;

import com.micanasta.model.Familia;
import com.micanasta.model.Heartbeat;
import com.micanasta.model.Solicitud;
import com.micanasta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

}
