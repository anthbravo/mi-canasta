package com.micanasta.dto.converter;

import com.micanasta.dto.RolPorUsuarioDto;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.RolPorUsuarioIdentity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolPorUsuarioDtoConverter {

    private final ModelMapper modelMapper;

    public RolPorUsuarioDto convertToDto(RolPorUsuario rolPorUsuario){
        return modelMapper.map(rolPorUsuario, RolPorUsuarioDto.class);
    }

    public RolPorUsuario convertToEntity(RolPorUsuarioDto rolPorUsuarioDto) {
        return modelMapper.map(rolPorUsuarioDto, RolPorUsuario.class);
    }
}
