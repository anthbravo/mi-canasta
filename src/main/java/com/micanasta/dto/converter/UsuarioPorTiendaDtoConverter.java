
package com.micanasta.dto.converter;

import com.micanasta.dto.UsuarioPorTiendaDto;
import com.micanasta.model.UsuarioPorTienda;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioPorTiendaDtoConverter {

    private final ModelMapper modelMapper;

    public UsuarioPorTiendaDto convertToDto(UsuarioPorTienda usuarioPorTienda) {
        return modelMapper.map(usuarioPorTienda, UsuarioPorTiendaDto.class);

    }

    public UsuarioPorTienda convertToEntity(UsuarioPorTiendaDto usuarioPorTiendaDto) {
        return modelMapper.map(usuarioPorTiendaDto, UsuarioPorTienda.class);

    }

}
