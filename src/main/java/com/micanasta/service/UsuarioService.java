package com.micanasta.service;

import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.dto.UsuarioUpdateDto;
import com.micanasta.exception.ActualPasswordNotMatchException;
import com.micanasta.exception.EmailWrongFormatException;
import com.micanasta.exception.NewPasswordNotMatchException;

public interface UsuarioService {

    UsuarioDto save(UsuarioReniecDto usuario);

    UsuarioDto findByDni(String dni);

    UsuarioAccesoDto ValidateLogin(String dni, String contrasena);

    UsuarioUpdateDto update(String dni, UsuarioUpdateDto usuarioUpdateDto) throws EmailWrongFormatException, NewPasswordNotMatchException, ActualPasswordNotMatchException;
    //Usuario validarDni(String dni);

}
