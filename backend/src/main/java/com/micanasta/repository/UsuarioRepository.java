package com.micanasta.repository;

import com.micanasta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByDni(String dni);

    @Query("SELECT u FROM Usuario u WHERE u.dni = :dni")
    Usuario encontrarPorDni(String dni);
}

