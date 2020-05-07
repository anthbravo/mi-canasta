package com.micanasta.service.impl;

import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.model.Solicitud;
import com.micanasta.repository.SolicitudRepository;
import com.micanasta.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public SolicitudBusquedaDto solicitudPorDni(String dni) {

        SolicitudBusquedaDto solicitudBusquedaDto = new SolicitudBusquedaDto();

        Optional<Solicitud> solicitud = solicitudRepository.findBySolicitudIdentityUsuarioDni(dni);

        if (solicitud.isPresent()) {
            solicitudBusquedaDto.setDni(dni);
            solicitudBusquedaDto.setNombreFamilia(solicitud.get().getSolicitudIdentity().getFamilia().getNombreUnico());
        } else {
            solicitudBusquedaDto = null;
        }

        return solicitudBusquedaDto;
    }

}
