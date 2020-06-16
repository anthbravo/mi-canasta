package com.micanasta.repository;

import com.micanasta.model.RolPerfil;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.RolPorUsuarioIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolPorUsuarioRepository extends JpaRepository<RolPorUsuario, RolPorUsuarioIdentity> {
    RolPorUsuario findByRolPorUsuarioIdentityUsuarioDni(String dni);
    void deleteByRolPorUsuarioIdentityUsuarioDni(String dni);

    @Query(value = "select * from `roles_por_usuario` ru where ru.`usuario_id` = ?1", nativeQuery = true)
    List<RolPorUsuario> findAllById(String dni);
}
