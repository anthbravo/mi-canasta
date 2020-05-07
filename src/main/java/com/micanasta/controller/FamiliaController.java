package com.micanasta.controller;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaDTO;
import com.micanasta.model.Familia;
import com.micanasta.service.FamiliaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @PostMapping("/familias")
    public ResponseEntity<?> crearFamilia(@Valid @RequestBody CrearFamiliaDTO familiaDto) {
        try {
            Familia result = familiaService.crearGrupoFamiliar(familiaDto);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya existe el grupo familiar :(");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado el grupo familiar :)");
        //return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.crearGrupoFamiliar(familiaDto));
    }
}
