package com.micanasta.repository;

import com.micanasta.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

    Familia findByNombreUnico(String nombreFamilia);

}
