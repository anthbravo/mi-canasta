package com.micanasta.controller;

import javax.validation.Valid;

import com.micanasta.dto.SolicitudAcceptedDto;
import com.micanasta.exception.SolicitudeTroubleException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.exception.FamilyNotAceptedSolicitudeException;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.service.SolicitudService;

import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.util.List;

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

    @GetMapping("/solicitudes")
    public ResponseEntity<?> obtenerSolicitud(@RequestParam(value="dni", required = false) String dni, @RequestParam(value="familiaId", required=false) Long idFamilia) {

        if (dni!= null && idFamilia == null) {
            SolicitudBusquedaDto solicitudBusquedaDto = solicitudService.solicitudPorDni(dni);

            return ResponseEntity.status(solicitudBusquedaDto != null ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                    .body(solicitudBusquedaDto);
        }else if (dni==null && idFamilia != null){

            List<SolicitudAcceptedDto> solicitudAcceptedDtoList = solicitudService.GetSolicitudesByFamiliaId(idFamilia);
            return ResponseEntity.status(solicitudAcceptedDtoList!=null?HttpStatus.OK:HttpStatus.NO_CONTENT).body(solicitudAcceptedDtoList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/solicitudes/{dni}")
    public ResponseEntity<?> denegarSolicitud(@PathVariable(name = "dni") String dni){
        try{
            boolean res = solicitudService.deleteSolicitudByDni(dni);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(SolicitudeTroubleException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getExceptionDto());
        }
    }
}
