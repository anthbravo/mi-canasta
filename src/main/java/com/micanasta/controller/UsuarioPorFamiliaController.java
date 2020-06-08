package com.micanasta.controller;

import com.micanasta.dto.SolicitudUsuarioDto;
import com.micanasta.exception.SolicitudeTroubleException;
import com.micanasta.service.impl.UsuarioPorFamiliaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequiredArgsConstructor
public class UsuarioPorFamiliaController {
    @Autowired
    UsuarioPorFamiliaServiceImpl usuarioPorFamiliaService;

    @PostMapping("/usuariosporfamilia")
    public ResponseEntity<?> AceptaSolicitudUsuario(@RequestBody SolicitudUsuarioDto solicitudUsuarioDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioPorFamiliaService.AceptaSolicitudUsuario(solicitudUsuarioDto));
        } catch (SolicitudeTroubleException solicitudeTroubleException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(solicitudeTroubleException.exceptionDto);
        }
    }

}
