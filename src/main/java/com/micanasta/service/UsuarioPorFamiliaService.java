package com.micanasta.service;

import com.micanasta.dto.UsuarioPorFamiliaDto;
import com.micanasta.model.UsuarioPorFamilia;

public interface UsuarioPorFamiliaService {
    UsuarioPorFamiliaDto Remove(String adminDni, String
            userDni);
}
