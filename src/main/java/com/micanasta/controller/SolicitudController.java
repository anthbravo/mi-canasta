package com.micanasta.controller;

import com.micanasta.Dto.SolicitudBusquedaDto;
import com.micanasta.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SolicitudController {

    @Autowired
    SolicitudService solicitudService;

    @GetMapping("/solicitudes/{dni}")
    public ResponseEntity<?> obtenerSolicitud(@PathVariable("dni") String dni) {

        SolicitudBusquedaDto solicitudBusquedaDto = solicitudService.solicitudPorDni(dni);

        return ResponseEntity.status(solicitudBusquedaDto != null ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(solicitudBusquedaDto);

    }


}