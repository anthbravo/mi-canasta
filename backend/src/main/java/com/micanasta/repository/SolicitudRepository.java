package com.micanasta.repository;

import com.micanasta.dto.SolicitudAcceptedDto;
import com.micanasta.model.Solicitud;
import com.micanasta.model.SolicitudIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    Optional<Solicitud> findBySolicitudIdentityUsuarioDni(String dni);
    Optional<Solicitud> findBySolicitudIdentityFamiliaId(Long idFamilia);
//    @Query(value = "SELECT * FROM `micanasta`.solicitudes s WHERE s.`familia_id` = ?1", nativeQuery = true )
    List<Solicitud> findAllBySolicitudIdentityFamiliaId (Long id);


//    @Query(value = "SELECT usuario_id dni, familia_id familiaId FROM `micanasta`.solicitudes s WHERE s.`familia_id` = ?1", nativeQuery = true )
//    List<SolicitudAcceptedDto> findAllById(Long idFamilia);

}
