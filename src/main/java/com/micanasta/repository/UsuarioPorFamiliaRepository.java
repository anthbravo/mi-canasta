package com.micanasta.repository;

import com.micanasta.model.UsuarioPorFamilia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioPorFamiliaRepository extends JpaRepository<UsuarioPorFamilia, Long> {

    Optional<List<UsuarioPorFamilia>> findByUsuarioPorFamiliaIdentityFamiliaNombreUnico(String nombreFamilia);
    Optional<UsuarioPorFamilia> findByUsuarioPorFamiliaIdentityUsuarioDni(String dni);
    void deleteByUsuarioPorFamiliaIdentityUsuarioDni(String dni);
}
