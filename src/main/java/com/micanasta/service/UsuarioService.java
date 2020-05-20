package com.micanasta.service;

import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioReniecDto;

public interface UsuarioService {

    UsuarioDto save(UsuarioReniecDto usuario);

    UsuarioDto findByDni(String dni);

    UsuarioAccesoDto ValidateLogin(String dni, String contrasena);


    //Usuario validarDni(String dni);

}
