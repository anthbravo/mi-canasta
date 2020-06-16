package com.micanasta.dto.converter;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.SolicitudDto;
import com.micanasta.model.Solicitud;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SolicitudDtoConverter {

    private final ModelMapper modelMapper;

    public SolicitudDto convertToDto(Solicitud solicitud) {
        return modelMapper.map(solicitud, SolicitudDto.class);

    }

    public Solicitud convertToEntity(CrearSolicitudDto solicitudDto) {
        return modelMapper.map(solicitudDto, Solicitud.class);

    }

}
