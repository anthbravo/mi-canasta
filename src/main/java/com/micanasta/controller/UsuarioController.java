package com.micanasta.controller;

import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioLoginDto;
import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.service.impl.ReniecServiceImpl;
import com.micanasta.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("usuarios")
    public ResponseEntity<?> ValidarIngreso(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        UsuarioAccesoDto usuarioAccesoDto = usuarioService.ValidateLogin(usuarioLoginDto.dni,usuarioLoginDto.contrasena);
        if (usuarioAccesoDto.dni == null){
        return ResponseEntity.notFound().build();}
        else {return ResponseEntity.ok().body(usuarioAccesoDto);}
    }


}
