package com.micanasta.service;

import com.micanasta.Dto.FamiliaDto;
import com.micanasta.Dto.SolicitudBusquedaDto;
import com.micanasta.Dto.SolicitudDto;
import com.micanasta.Dto.converter.FamiliaDtoConverter;
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
    @Autowired
    private FamiliaDtoConverter familiaDtoConverter;

    public SolicitudBusquedaDto solicitudNombreFamilia(String dni){


        SolicitudIdentity solicitudIdentity = new SolicitudIdentity();
        SolicitudBusquedaDto solicitudBusquedaDto = new SolicitudBusquedaDto();
        Solicitud solicitud = new Solicitud();
        Familia familia = new Familia();

        solicitud = solicitudRepository.findByDni(dni);

        if(solicitud != null) {

            SolicitudDto solicitudDto = solicitudDtoConverter.convertToDto(solicitud);
            familia = familiaRepository.findById(solicitudDto.getFamiliaId());
            FamiliaDto familiaDto = familiaDtoConverter.convertToDto(familia);
            solicitudBusquedaDto.setDni(dni);
            solicitudBusquedaDto.setNombreUnico(familiaDto.getNombreUnico());


            return solicitudBusquedaDto;
        }
        return null;


    }



}
