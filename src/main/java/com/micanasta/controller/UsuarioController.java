package com.micanasta.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioDataDto;
import com.micanasta.dto.UsuarioLoginDto;
import com.micanasta.exception.UserLoginIncorrectException;
import com.micanasta.exception.UserLoginNotFoundException;
import com.micanasta.model.Familia;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.Tienda;
import com.micanasta.service.FamiliaService;
import com.micanasta.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private UsuarioPorFamiliaServiceImpl usuarioPorFamiliaService;
    @Autowired
    private UsuarioPorTiendaServiceImpl usuarioPorTiendaService;
    @Autowired
    private RolPorUsuarioServiceImpl rolPorUsuarioService;

    @PostMapping("usuarios")
    public ResponseEntity<?> ValidarIngreso(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        try{
            UsuarioAccesoDto usuarioAccesoDto = usuarioService.ValidateLogin(usuarioLoginDto.dni, usuarioLoginDto.contrasena);
            UsuarioDataDto usuarioDataDto = new UsuarioDataDto();
            usuarioDataDto.setUsuarioAccesoDto(usuarioAccesoDto);
            usuarioDataDto.setFamilia(usuarioPorFamiliaService.findFamiliaById(usuarioLoginDto.dni));
            usuarioDataDto.setTienda(usuarioPorTiendaService.findTiendaById(usuarioLoginDto.dni));
            usuarioDataDto.setRolPorUsuario(rolPorUsuarioService.findByDni(usuarioLoginDto.dni));
            return ResponseEntity.status(201).body(usuarioDataDto);
        }catch (UserLoginNotFoundException userLoginNotFoundException){
            return ResponseEntity.status(400).body(userLoginNotFoundException.exceptionDto);
        }catch (UserLoginIncorrectException userLoginIncorrectException){
            return ResponseEntity.status(400).body(userLoginIncorrectException.exceptionDto);
        }
    }
}
