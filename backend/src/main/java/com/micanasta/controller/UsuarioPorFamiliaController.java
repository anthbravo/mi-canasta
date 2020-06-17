package com.micanasta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.dto.SolicitudUsuarioDto;
import com.micanasta.exception.SolicitudeTroubleException;
import com.micanasta.service.impl.UsuarioPorFamiliaServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
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
