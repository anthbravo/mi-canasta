package com.micanasta.service;

import com.micanasta.dto.ImportarUsuarioReniecDTO;
import com.micanasta.model.Usuario;

import java.util.Optional;

public interface ReniecService {
    Usuario findByDni(String dni);
}
