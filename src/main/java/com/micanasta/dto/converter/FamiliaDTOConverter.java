package com.micanasta.dto.converter;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaDTO;
import com.micanasta.model.Familia;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class FamiliaDTOConverter {
    private final ModelMapper modelMapper;

    //mapExplicitly
    @PostConstruct
    public void init() {
        modelMapper.addMappings(new PropertyMap<Familia, FamiliaDTO>() {

            @Override
            protected void configure() {
                //map().setCategoryName(source.getCategory().getName());
            }
        });
    }

    //mapAutomatic
    public FamiliaDTO convertToDto(Familia familia) {
        return modelMapper.map(familia, FamiliaDTO.class);

    }

    public Familia convertToEntity(CrearFamiliaDTO familiaDto) {
        return modelMapper.map(familiaDto, Familia.class);

    }

}
