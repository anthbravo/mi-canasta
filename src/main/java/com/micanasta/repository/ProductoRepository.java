package com.micanasta.repository;

import com.micanasta.dto.ProductoDto;
import com.micanasta.model.Familia;
import com.micanasta.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto getById(long id);
}
