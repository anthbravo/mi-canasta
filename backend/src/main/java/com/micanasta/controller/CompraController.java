package com.micanasta.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.dto.CompraCreateDto;
import com.micanasta.dto.CompraUpdateDto;
import com.micanasta.service.CompraService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping("/compras")
    public ResponseEntity<?> create(@Valid @RequestBody CompraCreateDto compraDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(compraService.create(compraDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/compras")
    public ResponseEntity<?> update(@Valid @RequestBody CompraUpdateDto historialDto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(compraService.update(historialDto));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/compras")
    public ResponseEntity<?> getCompras(@RequestParam long idFamilia, @RequestParam String dni,
                                            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaInicio,
                                            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaFin) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(compraService.getCompras(idFamilia, dni, fechaInicio
                    , fechaFin));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }
}
