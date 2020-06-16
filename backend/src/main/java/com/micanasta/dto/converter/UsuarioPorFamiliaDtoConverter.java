
package com.micanasta.dto.converter;

import com.micanasta.dto.UsuarioPorFamiliaDto;
import com.micanasta.model.UsuarioPorFamilia;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioPorFamiliaDtoConverter {

    private final ModelMapper modelMapper;

    public UsuarioPorFamiliaDto convertToDto(UsuarioPorFamilia usuarioPorFamilia) {
        return modelMapper.map(usuarioPorFamilia, UsuarioPorFamiliaDto.class);

    }

    public UsuarioPorFamilia convertToEntity(UsuarioPorFamiliaDto usuarioPorFamiliaDto) {
        return modelMapper.map(usuarioPorFamiliaDto, UsuarioPorFamilia.class);

    }

}
