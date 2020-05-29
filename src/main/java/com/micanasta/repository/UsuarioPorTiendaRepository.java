package com.micanasta.repository;

import com.micanasta.model.UsuarioPorTienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioPorTiendaRepository extends JpaRepository<UsuarioPorTienda, Long> {

    @Query(value = "select `tienda_id` from `usuarios_por_tienda` ut where ut.`usuario_id` = ?1", nativeQuery = true)
    Long findByDni(String dni);

}
