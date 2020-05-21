package com.micanasta.repository;

import com.micanasta.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, String> {
    Familia findByNombreUnico(String nombreFamilia);
}
