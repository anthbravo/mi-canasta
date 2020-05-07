package com.micanasta.service;

import com.micanasta.Dto.SolicitudBusquedaDto;
import com.micanasta.Dto.converter.SolicitudDtoConverter;
import com.micanasta.model.Familia;
import com.micanasta.model.Solicitud;
import com.micanasta.model.SolicitudIdentity;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private FamiliaRepository familiaRepository;
    @Autowired
    private SolicitudDtoConverter solicitudDtoConverter;

    public SolicitudBusquedaDto solicitudNombreFamilia(String dni){

        //Solicitud solicitud = solicitudDtoConverter.convertToEntity();
        SolicitudIdentity solicitudIdentity = new SolicitudIdentity();
        SolicitudBusquedaDto solicitudBusquedaDto = new SolicitudBusquedaDto();

        long dniFamilia = solicitudRepository.findByDni(dni);
        String nombreFamilia= familiaRepository.findById(dniFamilia);

        solicitudBusquedaDto.setDni(dni);
        solicitudBusquedaDto.setNombreUnico(nombreFamilia);

        return solicitudBusquedaDto;





    }



}
