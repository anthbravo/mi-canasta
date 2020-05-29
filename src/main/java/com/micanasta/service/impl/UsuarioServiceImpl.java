package com.micanasta.service.impl;

import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.exception.UserLoginIncorrectException;
import com.micanasta.exception.UserLoginNotFoundException;
import com.micanasta.dto.UsuarioUpdateDto;
import com.micanasta.exception.ActualPasswordNotMatchException;
import com.micanasta.exception.EmailWrongFormatException;
import com.micanasta.exception.NewPasswordNotMatchException;
import com.micanasta.model.Solicitud;
import com.micanasta.model.Usuario;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public UsuarioAccesoDto ValidateLogin(String dni, String contrasena)
            throws UserLoginIncorrectException, UserLoginNotFoundException {
        ReniecServiceImpl reniecService = new ReniecServiceImpl();
        UsuarioDto usuarioDto = findByDni(dni);
        if (usuarioDto.dni == null) {
            UsuarioReniecDto resultIdentity = reniecService.validateIdentity(dni);
            if (resultIdentity.dni.equals("NotExist")) {
                throw new UserLoginNotFoundException();
            }
            Object result = save(resultIdentity);
            return modelMapper.map(result, UsuarioAccesoDto.class);
        }
        if (usuarioDto.contrasena.equals(contrasena)) {
            return modelMapper.map(usuarioDto, UsuarioAccesoDto.class);
        } else {
            throw new UserLoginIncorrectException();
        }
    }

    public static boolean correoValido(String email) {
        if (email == null)
            return true;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    @Override
    public UsuarioUpdateDto update(String dni, UsuarioUpdateDto usuarioUpdateDto)
            throws EmailWrongFormatException, NewPasswordNotMatchException, ActualPasswordNotMatchException {
        Usuario entry = usuarioRepository.findByDni(dni);

        if (correoValido(usuarioUpdateDto.correoElectronico) == false) {
            throw new EmailWrongFormatException();
        }
        if (usuarioUpdateDto.contrasena != null) {
            if (!usuarioUpdateDto.contrasena.equals(entry.getContrasena())) {
                throw new ActualPasswordNotMatchException();
            }
        } else {
            throw new ActualPasswordNotMatchException();
        }

        if (usuarioUpdateDto.nuevaContrasena != null && usuarioUpdateDto.repetirContrasena != null) {
            if (!usuarioUpdateDto.nuevaContrasena.equals(usuarioUpdateDto.repetirContrasena)) {
                throw new NewPasswordNotMatchException();
            }
        }

        if (usuarioUpdateDto.contrasena != null) {
            if (usuarioUpdateDto.correoElectronico != null)
                entry.setCorreoElectronico(usuarioUpdateDto.correoElectronico);
            if (usuarioUpdateDto.nuevaContrasena != null)
                entry.setContrasena(usuarioUpdateDto.nuevaContrasena);
            usuarioRepository.save(entry);
        }
        return usuarioUpdateDto;
    }

}
