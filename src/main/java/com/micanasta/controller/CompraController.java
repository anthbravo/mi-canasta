package com.micanasta.controller;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.CompraCreateDto;
import com.micanasta.exception.ExistingFamilyFoundException;
import com.micanasta.service.CompraService;
import com.micanasta.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
