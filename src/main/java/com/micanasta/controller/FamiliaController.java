package com.micanasta.controller;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.service.FamiliaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @PostMapping("/familias")
    public ResponseEntity<?> newFamilia (@Valid @RequestBody CrearFamiliaDTO familiaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.crearGrupoFamiliar(familiaDto));
    }

}
