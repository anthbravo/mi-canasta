package com.micanasta.dto.converter;


import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.RolPorPerfilListaDto;

import com.micanasta.model.RolPerfil;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolPorPerfilDtoConverter {

    private final ModelMapper modelMapper;

    public RolPorPerfilListaDto convertToDto(RolPerfil rolPerfil) {
        return modelMapper.map( rolPerfil , RolPorPerfilListaDto.class);

    }

    public RolPerfil convertToEntity(RolPorPerfilListaDto rolPorPerfilListaDto) {
        return modelMapper.map(rolPorPerfilListaDto, RolPerfil.class);

    }

}
