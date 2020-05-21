package com.micanasta.service.impl;

import com.micanasta.dto.UsuarioAccesoDto;
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
    private ModelMapper modelMapper = new ModelMapper();


    public UsuarioDto save(UsuarioReniecDto model) {
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

    public UsuarioDto findByDni(String dni) {
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(dni);

            return modelMapper.map(usuario.get(), UsuarioDto.class);
        } catch (Exception exception) {
            return new UsuarioDto();
        }
    }

    public UsuarioAccesoDto ValidateLogin(String dni, String contrasena) {
        ReniecServiceImpl reniecService = new ReniecServiceImpl();
        UsuarioDto usuarioDto = findByDni(dni);
        if (usuarioDto.dni == null) {
            UsuarioReniecDto resultIdentity = reniecService.validateIdentity(dni);

            if (resultIdentity.dni == "NotExist") {
                UsuarioDto usuarioDto1 = new UsuarioDto();
                usuarioDto1.dni = "NotExist";
                return modelMapper.map(usuarioDto1, UsuarioAccesoDto.class);
            }
            Object result = save(resultIdentity);
            return modelMapper.map(result, UsuarioAccesoDto.class);
        }
        if (usuarioDto.contrasena.equals(contrasena)) {
            return modelMapper.map(usuarioDto, UsuarioAccesoDto.class);
        }
        UsuarioAccesoDto usuarioAccesoDto = new UsuarioAccesoDto();
        usuarioAccesoDto.dni = "NotFound";
        return usuarioAccesoDto;

    }
}
//

