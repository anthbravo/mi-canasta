package com.micanasta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.exception.FamilyNotAceptedSolicitudeException;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.service.SolicitudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/solicitudes")
    public ResponseEntity<?> createSolicitud(@Valid @RequestBody CrearSolicitudDto solicitudDto) throws FamilyNotAceptedSolicitudeException, FamilyNotFoundException {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(solicitudService.create(solicitudDto));
        } catch (FamilyNotFoundException familyNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(familyNotFoundException.exceptionDto);
        } catch (FamilyNotAceptedSolicitudeException familyNotAceptedSolicitudeException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(familyNotAceptedSolicitudeException.exceptionDto);
        }
    }

    @GetMapping("/solicitudes/{dni}")
    public ResponseEntity<?> obtenerSolicitud(@PathVariable("dni") String dni) {

        SolicitudBusquedaDto solicitudBusquedaDto = solicitudService.solicitudPorDni(dni);

        return ResponseEntity.status(solicitudBusquedaDto != null ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(solicitudBusquedaDto);

    }
}
