package com.micanasta.service;

import com.micanasta.dto.SolicitudUsuarioDto;
import com.micanasta.exception.SolicitudeTroubleException;
import com.micanasta.model.Familia;

public interface UsuarioPorFamiliaService {
    boolean AceptaSolicitudUsuario (SolicitudUsuarioDto solicitudUsuarioDto)throws SolicitudeTroubleException;
    Familia findFamiliaById(String dni);
}
