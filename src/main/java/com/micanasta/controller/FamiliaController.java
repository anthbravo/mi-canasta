package com.micanasta.controller;
import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaDTO;

import com.micanasta.model.Familia;
import com.micanasta.model.Heartbeat;
import com.micanasta.service.FamiliaService;
import com.micanasta.service.HeartbeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/familias")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })

public class FamiliaController {

    @Autowired
    FamiliaService familiaService;

    @GetMapping()
    public ResponseEntity<List<Familia>> getAll() {

        List<Familia> familias = familiaService.getAll();

        if (familias.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(familias);
        }

    }
}

/*@RequestMapping("/familias")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })

@RestController
@RequiredArgsConstructor
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @GetMapping("/familias")
    public ResponseEntity<?> getAll() {
        List<FamiliaDTO> familias=familiaService.findAll();

        if (familias.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(familias);
        }
    }

    @GetMapping("/familias/")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<FamiliaDTO> result = familiaService.findById(id);
        if (!result.isPresent())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(result);
    }

    @PostMapping("/familias")
    public ResponseEntity<?> newFamilia (@RequestBody CrearFamiliaDTO familiaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.save(familiaDto));

    }

    /*@DeleteMapping("/familias/{id}")
    public ResponseEntity<?> deleteFamilia (@PathVariable Long id) {
        familiaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/

