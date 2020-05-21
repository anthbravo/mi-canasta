package com.micanasta.service;

import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.exception.UserLoginIncorrectException;
import com.micanasta.exception.UserLoginNotFoundException;

public interface UsuarioService {

    UsuarioDto save(UsuarioReniecDto usuario);

    UsuarioDto findByDni(String dni);

    UsuarioAccesoDto ValidateLogin (String dni, String contrasena)throws UserLoginIncorrectException, UserLoginNotFoundException;

    //Usuario validarDni(String dni);

}
