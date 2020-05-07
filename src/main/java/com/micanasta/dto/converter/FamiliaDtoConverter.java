package com.micanasta.dto.converter;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.FamiliaDto;
import com.micanasta.dto.SolicitudDto;
import com.micanasta.model.Familia;
import com.micanasta.model.Solicitud;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FamiliaDtoConverter {

    private final ModelMapper modelMapper;

    public FamiliaDto convertToDto(Familia familia) {
        return modelMapper.map(familia, FamiliaDto.class);

    }

    public Familia convertToEntity(FamiliaDto familiaDto) {
        return modelMapper.map(familiaDto, Familia.class);

    }

}