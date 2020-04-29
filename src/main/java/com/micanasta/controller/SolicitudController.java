package com.micanasta.controller;

import com.micanasta.model.Solicitud;
import com.micanasta.service.SolicitudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class SolicitudController {

    @Autowiredd
    SolicitudService solicitudService;

    @GetMapping()
    public ResponseEntity<List<Solicitud>> getAll() {

        List<Solicitud> solicitudes= solicitudService.getAll();

        if (solicitudes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(solicitudes);
        }

    }
}