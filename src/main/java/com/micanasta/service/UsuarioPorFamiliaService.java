package com.micanasta.service;

import com.micanasta.dto.SolicitudUsuarioDto;
import com.micanasta.exception.SolicitudeTroubleException;

public interface UsuarioPorFamiliaService {
    boolean AceptaSolicitudUsuario (SolicitudUsuarioDto solicitudUsuarioDto)throws SolicitudeTroubleException;
}
