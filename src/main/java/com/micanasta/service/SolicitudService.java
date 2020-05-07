package com.micanasta.service;

import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.model.Solicitud;

public interface SolicitudService {

    SolicitudBusquedaDto solicitudPorDni(String dni);

    Solicitud create(CrearSolicitudDto familiaDto);

    boolean aceptaSolicitudes(CrearSolicitudDto solicitudDto);

}
