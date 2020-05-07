package com.micanasta.Dto.converter;

import com.micanasta.Dto.FamiliaDto;
import com.micanasta.model.Familia;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FamiliaDtoConverter {

    private final ModelMapper modelMapper;

    //mapExplicitly

    //mapAutomatic
    public FamiliaDto convertToDto(Familia familia) {
        return modelMapper.map(familia, FamiliaDto.class);

    }


}
