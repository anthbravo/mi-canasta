package com.micanasta.service.impl;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.converter.SolicitudConverter;
import com.micanasta.model.Solicitud;
import com.micanasta.repository.SolicitudRepository;
import com.micanasta.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private SolicitudConverter solicitudConverter;

    @Override
    @Transactional
    public Solicitud create(CrearSolicitudDto solicitudDto) {
        Solicitud solicitud = solicitudConverter.convertToEntity(solicitudDto);
        solicitud = solicitudRepository.save(solicitud);
        return solicitud;

    }
}
