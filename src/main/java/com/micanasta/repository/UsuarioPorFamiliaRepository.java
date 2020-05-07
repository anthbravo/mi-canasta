package com.micanasta.repository;

import com.micanasta.model.Solicitud;
import com.micanasta.model.UsuarioPorFamilia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioPorFamiliaRepository extends JpaRepository <UsuarioPorFamilia, Long> {
Optional<UsuarioPorFamilia> findByUsuarioPorFamiliaIdIdentity_Familia(long id);
}
