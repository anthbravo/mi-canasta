package com.micanasta.repository;

import com.micanasta.model.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaRepository extends JpaRepository<Tienda, Long> {
    Tienda getById(long id);
}
