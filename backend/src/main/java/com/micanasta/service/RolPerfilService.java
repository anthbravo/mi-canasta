package com.micanasta.service;

import com.micanasta.dto.CambioRolPerfilDto;
import com.micanasta.model.RolPorUsuario;

import java.util.List;

public interface RolPerfilService {

    CambioRolPerfilDto EditRolPerfil(String dni, List <Long> ids );
}
