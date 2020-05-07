package com.micanasta.repository;

import com.micanasta.model.Familia;
import com.micanasta.model.UsuarioPorFamilia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    Familia findByNombreUnico(String nombreFamilia);
}
