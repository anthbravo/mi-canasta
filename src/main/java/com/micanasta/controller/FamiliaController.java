package com.micanasta.controller;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.model.Familia;
import com.micanasta.model.UsuarioPorFamilia;
import com.micanasta.service.FamiliaService;
import com.micanasta.service.UsuarioPorFamiliaService;
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

    @Autowired
    private UsuarioPorFamiliaService usuarioPorFamiliaService;

    @PostMapping("/familias")
    public ResponseEntity<?> crearFamilia(@Valid @RequestBody CrearFamiliaDTO familiaDto) {
        try {
            Familia result = familiaService.crearGrupoFamiliar(familiaDto);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya existe el grupo familiar :(");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado el grupo familiar :)");
    }

    @GetMapping("/familias/{nombreFamilia}/usuarios")
    public ResponseEntity<?> buscarMiembrosGrupoFamiliarPorNombreFamilia(@PathVariable("nombreFamilia") String nombreFamilia) throws FamilyNotFoundException {

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(familiaService.buscarMiembrosGrupoFamiliarPorNombreFamilia(nombreFamilia));
        } catch (FamilyNotFoundException familyNotFoundException) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(familyNotFoundException.exceptionDto);
        }
    }

    @DeleteMapping("/familias/{nombreFamilia}/usuarios/{dni}")
    public ResponseEntity<?> deleteUsuarioDeFamilia(String adminDni, @PathVariable String dni ){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioPorFamiliaService.Remove(adminDni, dni));
    }

}
