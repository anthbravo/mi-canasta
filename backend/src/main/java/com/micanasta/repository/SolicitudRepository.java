package com.micanasta.repository;

import com.micanasta.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    Optional<Solicitud> findBySolicitudIdentityUsuarioDni(String dni);
    Optional<Solicitud> findBySolicitudIdentityFamiliaId(Long idFamilia);

}
