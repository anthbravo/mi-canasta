package com.micanasta.controller;

import com.micanasta.Dto.SolicitudBusquedaDto;
import com.micanasta.model.Solicitud;
import com.micanasta.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SolicitudController {

    @Autowired
    SolicitudService solicitudService;

    @GetMapping("/solicitudes")
    public ResponseEntity<?> BusquedaDni(@Valid @RequestBody String dni){

        SolicitudBusquedaDto result = solicitudService.solicitudNombreFamilia(dni);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }



}