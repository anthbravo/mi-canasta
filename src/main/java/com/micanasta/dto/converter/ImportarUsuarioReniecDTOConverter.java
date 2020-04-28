package com.micanasta.dto.converter;

import com.micanasta.dto.ImportarUsuarioReniecDTO;
import com.micanasta.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ImportarUsuarioReniecDTOConverter {
    private final ModelMapper modelMapper;

    @PostConstruct
    public void init(){
        modelMapper.addMappings(new PropertyMap<Usuario, ImportarUsuarioReniecDTO>() {
            @Override
            protected void configure(){
                map().setCategoryName(source.getCategory().getName());
            }
        });
    }
public ImportarUsuarioReniecDTO convertToDto(Usuario usuario){
        return modelMapper.map(usuario,ImportarUsuarioReniecDTO.class);
}
public Usuario convertToEntity(ImportarUsuarioReniecDTO importarUsuarioReniecDTO){
        return modelMapper.map(importarUsuarioReniecDTO,Usuario.class);
}
}

