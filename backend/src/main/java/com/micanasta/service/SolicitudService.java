package com.micanasta.service;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.SolicitudAcceptedDto;
import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.dto.SolicitudUsuarioDto;
import com.micanasta.exception.FamilyNotAceptedSolicitudeException;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.exception.SolicitudeNotFoundException;
import com.micanasta.exception.SolicitudeTroubleException;
import com.micanasta.model.Solicitud;

import java.util.List;
import java.util.Optional;

public interface SolicitudService {
    Solicitud create(CrearSolicitudDto familiaDto) throws FamilyNotFoundException, FamilyNotAceptedSolicitudeException;

    boolean aceptaSolicitudes(CrearSolicitudDto solicitudDto);

    SolicitudBusquedaDto solicitudPorDni(String dni);

    boolean borrarSolicitud(SolicitudUsuarioDto solicitudUsuarioDto);

    List<SolicitudAcceptedDto> GetSolicitudesByFamiliaId(Long idFamilia);

    boolean deleteSolicitudByDni(String dni) throws SolicitudeTroubleException;
}
