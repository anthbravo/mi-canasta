package com.micanasta.repository;

import com.micanasta.model.UsuarioPorFamilia;
import com.micanasta.model.UsuarioPorFamiliaIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPorFamiliaRepository extends JpaRepository<UsuarioPorFamilia, UsuarioPorFamiliaIdentity> {
}
