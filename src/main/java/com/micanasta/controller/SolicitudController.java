package com.micanasta.controller;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/solicitudes")
    public ResponseEntity<?> newSolicitud(@Valid @RequestBody CrearSolicitudDto solicitudDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudService.create(solicitudDto));
    }
}