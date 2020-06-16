package com.micanasta.repository;

import com.micanasta.model.UsuarioPorFamilia;
import com.micanasta.model.UsuarioPorTienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioPorTiendaRepository extends JpaRepository<UsuarioPorTienda, Long> {

    Optional<List<UsuarioPorTienda>> findByUsuarioPorTiendaIdentityTiendaId(long id);

    @Query(value = "select `tienda_id` from `usuarios_por_tienda` ut where ut.`usuario_id` = ?1", nativeQuery = true)
    Long findByDni(String dni);

    @Query(value = "select COUNT(`usuario_id`) from `usuarios_por_tienda` ut where ut.`tienda_id` = ?1", nativeQuery = true)
    Long countById(long tiendaId);

    Optional<UsuarioPorTienda> findByUsuarioPorTiendaIdentityUsuarioDni(String dni);

}
