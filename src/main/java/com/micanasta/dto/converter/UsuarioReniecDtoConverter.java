package com.micanasta.dto.converter;

import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioReniecDtoConverter {

    private final ModelMapper modelMapper=new ModelMapper();


    public UsuarioReniecDto convertToDto(Usuario usuario)
    {
        return modelMapper.map(usuario,UsuarioReniecDto.class);
    }

    public Usuario convertToEntity(UsuarioReniecDto usuarioReniecDTO)
    {
        return modelMapper.map(usuarioReniecDTO, Usuario.class);
    }
}

