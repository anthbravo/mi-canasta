package com.micanasta.service.impl;

import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.model.Usuario;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper=new ModelMapper();


    public UsuarioDto save(UsuarioReniecDto model)
    {
        Usuario usuario = new Usuario();
        usuario.setDni(model.dni);
        usuario.setNombre(model.nombre1 + " " + model.nombre2);
        usuario.setApellidoMaterno(model.apellidoMaterno);
        usuario.setApellidoPaterno(model.apellidoPaterno);
        usuario.setContrasena(model.dni);
        usuario.setCorreoElectronico(" ");
        usuarioRepository.save(usuario);

        return modelMapper.map(usuario, UsuarioDto.class);
    }
    public UsuarioDto findByDni(String dni)
    {
//        try {
            Object usuario = usuarioRepository.findById(dni);

            return modelMapper.map(usuario, UsuarioDto.class);
//        }
//        catch ( ){
//            return new UsuarioDto();
//        }
    }
}
//

