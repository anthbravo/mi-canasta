package com.micanasta.service;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.exception.FamilyNotAceptedSolicitudeException;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.model.Solicitud;

public interface SolicitudService {
    Solicitud create(CrearSolicitudDto familiaDto) throws FamilyNotFoundException, FamilyNotAceptedSolicitudeException;

    boolean aceptaSolicitudes(CrearSolicitudDto solicitudDto);

    SolicitudBusquedaDto solicitudPorDni(String dni);

}
