package com.micanasta.service;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.model.Solicitud;

public interface SolicitudService {
    Solicitud create(CrearSolicitudDto familiaDto);

    boolean aceptaSolicitudes(CrearSolicitudDto solicitudDto);

}
