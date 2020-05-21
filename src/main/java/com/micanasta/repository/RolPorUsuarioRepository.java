package com.micanasta.repository;

import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.RolPorUsuarioIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface RolPorUsuarioRepository extends JpaRepository<RolPorUsuario, RolPorUsuarioIdentity> {

    void deleteByRolPorUsuarioIdentityUsuarioDni(String dni);
}
