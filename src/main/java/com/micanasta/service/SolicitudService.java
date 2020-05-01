package com.micanasta.service;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.model.Familia;
import com.micanasta.model.Solicitud;
import com.micanasta.model.Usuario;

public interface SolicitudService
{
    Solicitud create(CrearSolicitudDto familiaDto);

}
