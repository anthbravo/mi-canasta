package com.micanasta.service;

import com.micanasta.model.Familia;
import com.micanasta.model.UsuarioPorFamilia;

import java.util.List;
import java.util.Optional;

public interface FamiliaService {
    Familia getByNombre(String nombre);
    Optional<UsuarioPorFamilia> getUsuariosPorFamilia(String nombre);
}
