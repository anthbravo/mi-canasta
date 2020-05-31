package com.micanasta.repository;

import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.RolPorUsuarioIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolPorUsuarioRepository extends JpaRepository<RolPorUsuario, RolPorUsuarioIdentity> {
    RolPorUsuario findByRolPorUsuarioIdentityUsuarioDni(String dni);
    void deleteByRolPorUsuarioIdentityUsuarioDni(String dni);

    List<RolPorUsuario> findAllById(String dni);
}
