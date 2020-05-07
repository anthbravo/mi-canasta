package com.micanasta.service;

import com.micanasta.Dto.SolicitudBusquedaDto;


public interface SolicitudService {
    SolicitudBusquedaDto solicitudPorDni(String dni);
}
