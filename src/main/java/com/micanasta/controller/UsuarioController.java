package com.micanasta.controller;

import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioLoginDto;
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
        UsuarioAccesoDto usuarioAccesoDto = usuarioService.ValidateLogin(usuarioLoginDto.dni, usuarioLoginDto.contrasena);
        if (usuarioAccesoDto.dni == "NotFound") {
            return ResponseEntity.status(401).body(usuarioAccesoDto);
        }
        if (usuarioAccesoDto.dni == "NotExist") {
            return ResponseEntity.status(404).body(usuarioAccesoDto);
        } else {
            return ResponseEntity.ok().body(usuarioAccesoDto);
        }
    }


}
