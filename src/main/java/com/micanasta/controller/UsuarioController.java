package com.micanasta.controller;

import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioLoginDto;
import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.model.Usuario;
import com.micanasta.service.ReniecService;
import com.micanasta.service.impl.ReniecServiceImpl;
import com.micanasta.service.impl.UsuarioServiceImpl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private ReniecServiceImpl reniecService;

    @PostMapping("usuarios")
    public ResponseEntity<?> ValidarIngreso(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        UsuarioDto response3 = usuarioService.findByDni(usuarioLoginDto.dni);

        UsuarioReniecDto response = reniecService.validarIdentidad(usuarioLoginDto.dni);
        UsuarioDto response2 = usuarioService.save(response);

        return ResponseEntity.ok().build();
    }


}
