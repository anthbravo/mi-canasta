package com.micanasta.repository;

import com.micanasta.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    Familia findByNombreUnico(String nombreFamilia);
}
