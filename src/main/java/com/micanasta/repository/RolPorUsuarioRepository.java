package com.micanasta.repository;

import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.RolPorUsuarioIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolPorUsuarioRepository extends JpaRepository<RolPorUsuario, RolPorUsuarioIdentity > {
}
