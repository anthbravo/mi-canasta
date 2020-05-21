package com.micanasta.controller;

import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioLoginDto;
import com.micanasta.exception.UserLoginIncorrectException;
import com.micanasta.exception.UserLoginNotFoundException;
import com.micanasta.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("usuarios")
    public ResponseEntity<?> ValidarIngreso(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        try{
        UsuarioAccesoDto usuarioAccesoDto = usuarioService.ValidateLogin(usuarioLoginDto.dni, usuarioLoginDto.contrasena);

            return ResponseEntity.status(201).body(usuarioAccesoDto);
        }catch (UserLoginNotFoundException userLoginNotFoundException){
            return ResponseEntity.status(400).body(userLoginNotFoundException.exceptionDto);
        }catch (UserLoginIncorrectException userLoginIncorrectException){
            return ResponseEntity.status(400).body(userLoginIncorrectException.exceptionDto);
        }
    }


}
