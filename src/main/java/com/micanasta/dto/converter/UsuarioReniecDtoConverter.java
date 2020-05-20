package com.micanasta.dto.converter;

import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioReniecDtoConverter {

    public ModelMapper modelMapper;

    public UsuarioReniecDto convertToDto(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioReniecDto.class);
    }

    public Usuario convertToEntity(UsuarioReniecDto usuarioReniecDTO) {
        return modelMapper.map(usuarioReniecDTO, Usuario.class);
    }
}

