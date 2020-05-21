package com.micanasta.repository;

import com.micanasta.model.UsuarioPorFamilia;
import com.micanasta.model.UsuarioPorFamiliaIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UsuarioPorFamiliaRepository extends JpaRepository<UsuarioPorFamilia, UsuarioPorFamiliaIdentity> {

    Optional<List<UsuarioPorFamilia>> findByUsuarioPorFamiliaIdentityFamiliaNombreUnico(String nombreFamilia);
    Optional<UsuarioPorFamilia> findByUsuarioPorFamiliaIdentityUsuarioDni(String dni);

    Optional<UsuarioPorFamilia> deleteByUsuarioPorFamiliaIdentityUsuarioDni(String dni);

}
