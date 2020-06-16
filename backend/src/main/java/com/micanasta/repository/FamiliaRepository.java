package com.micanasta.repository;

import com.micanasta.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

    Familia findByNombreUnico(String nombreFamilia);
    void deleteByNombreUnico(String nombreFamilia);

    @Query("select f from Familia f where f.id=:id")
    Familia encontrarPorId(long id);
}
