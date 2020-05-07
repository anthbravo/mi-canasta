package com.micanasta.service;

import com.micanasta.dto.SolicitudBusquedaDto;


public interface SolicitudService {
    SolicitudBusquedaDto solicitudPorDni(String dni);
}
