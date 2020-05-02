package com.micanasta.service;

import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.model.Usuario;

public interface ReniecService {

    UsuarioReniecDto validarIdentidad(String dni);
}
