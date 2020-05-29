package com.micanasta.repository;

import com.micanasta.model.UsuarioPorFamilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioPorFamiliaRepository extends JpaRepository<UsuarioPorFamilia, Long> {

    Optional<List<UsuarioPorFamilia>> findByUsuarioPorFamiliaIdentityFamiliaNombreUnico(String nombreFamilia);
    Optional<UsuarioPorFamilia> findByUsuarioPorFamiliaIdentityUsuarioDni(String dni);
    void deleteByUsuarioPorFamiliaIdentityUsuarioDni(String dni);
    int countByUsuarioPorFamiliaIdentityFamiliaNombreUnico(String nombreFamilia);

    @Query(value="select `familia_id` from `usuarios_por_familia` uf where uf.`usuario_id` = ?1",nativeQuery=true)
    Long findByDni(String dni);

}
