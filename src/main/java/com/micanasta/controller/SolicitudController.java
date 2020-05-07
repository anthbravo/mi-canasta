package com.micanasta.controller;

import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.model.Solicitud;
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
    private SolicitudService solicitudService;

    @GetMapping("/solicitudes/{dni}")
    public ResponseEntity<?> obtenerSolicitud(@PathVariable("dni") String dni) {

        SolicitudBusquedaDto solicitudBusquedaDto = solicitudService.solicitudPorDni(dni);

        return ResponseEntity.status(solicitudBusquedaDto != null ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(solicitudBusquedaDto);

    }


    @PostMapping("/solicitudes")
    public ResponseEntity<?> createSolicitud(@Valid @RequestBody CrearSolicitudDto solicitudDto) {

        Solicitud result = solicitudService.create(solicitudDto);

        if (result != null) {
            if (solicitudService.aceptaSolicitudes(solicitudDto) == false) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El grupo familiar no acepta solicitudes");
            } else return ResponseEntity.status(HttpStatus.OK).body(result);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El grupo familiar no existe");
    }
}