package com.micanasta.service;

import com.micanasta.dto.*;
import com.micanasta.exception.UserLoginIncorrectException;
import com.micanasta.exception.UserLoginNotFoundException;
import com.micanasta.exception.ActualPasswordNotMatchException;
import com.micanasta.exception.EmailWrongFormatException;
import com.micanasta.exception.NewPasswordNotMatchException;

public interface UsuarioService {

    UsuarioDto save(UsuarioReniecDto usuario);

    UsuarioDto findByDni(String dni);

    UsuarioAccesoDto ValidateLogin(String dni, String contrasena)
            throws UserLoginIncorrectException, UserLoginNotFoundException;

    UsuarioUpdateDto update(String dni, UsuarioUpdateDto usuarioUpdateDto)
            throws EmailWrongFormatException, NewPasswordNotMatchException, ActualPasswordNotMatchException;
    // Usuario validarDni(String dni);

    TiendaDto updateTienda(String dni, Long idTienda, TiendaUpdateDto tiendaUpdateDto) throws ActualPasswordNotMatchException;

}
