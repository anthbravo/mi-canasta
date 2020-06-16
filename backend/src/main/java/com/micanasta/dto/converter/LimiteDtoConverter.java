package com.micanasta.dto.converter;

import com.micanasta.dto.LimiteDto;
import com.micanasta.model.Limite;
import com.micanasta.model.Producto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LimiteDtoConverter {

    private final ModelMapper modelMapper;

    public LimiteDto convertToDto(Limite limite) {
        LimiteDto limiteDto = new LimiteDto();
        limiteDto.setCategoriaId(limite.getCategoria().getId());
        limiteDto.setCantidadXPersona(limite.getCantidadXPersona());
        limiteDto.setId(limite.getId());
        return limiteDto;
    }

    public Limite convertToEntity(LimiteDto limiteDto) {
        return modelMapper.map(limiteDto, Limite.class);
    }
}
