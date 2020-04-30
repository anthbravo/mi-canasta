package com.micanasta.controller;
import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaDTO;

import com.micanasta.model.Familia;
import com.micanasta.service.FamiliaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequiredArgsConstructor
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @GetMapping("/familias")
    public ResponseEntity<?> getAll() {
        List<FamiliaDTO> familias = familiaService.getAll();

        if (familias.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(familias);
        }
    }

    @GetMapping("/familias/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<FamiliaDTO> result = familiaService.findById(id);
        if (!result.isPresent())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(result);
    }

    /*@GetMapping("/familias/{nombreUnico}")
    public ResponseEntity<?> getAll(@PathVariable String nombreUnico) {
        List<FamiliaDTO> familias = familiaService.getAll();

        if (familias.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(familias);
        }
    }*/

    @PostMapping("/familias")
    public ResponseEntity<?> newFamilia (@RequestBody CrearFamiliaDTO familiaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.save(familiaDto));

    }

}
