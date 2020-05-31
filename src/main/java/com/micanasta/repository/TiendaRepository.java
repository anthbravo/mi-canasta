package com.micanasta.repository;

import com.micanasta.model.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TiendaRepository extends JpaRepository<Tienda, Long> {

    Tienda getById(long id);

    @Query("select t from Tienda t where t.id = :id")
    Tienda encontrarPorId(long id);
}
