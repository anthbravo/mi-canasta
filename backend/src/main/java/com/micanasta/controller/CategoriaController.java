package com.micanasta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {

        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getById(id));
    }

    @GetMapping("/categorias/{id}/limites")
    public ResponseEntity<?> getLimiteById(@PathVariable long id) {

        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getLimiteById(id));
    }
}
