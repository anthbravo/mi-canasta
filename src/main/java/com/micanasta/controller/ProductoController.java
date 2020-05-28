package com.micanasta.controller;

import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.service.FamiliaService;
import com.micanasta.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {

        return ResponseEntity.status(HttpStatus.OK).body(productoService.getById(id));
    }
}