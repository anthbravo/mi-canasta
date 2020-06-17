package com.micanasta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.service.RolPorUsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RolesPorUsuarioController {
    @Autowired
    private RolPorUsuarioService rolPorUsuarioService;

    @GetMapping("/rolesporusuario/{dni}")
    public ResponseEntity<?> getById(@PathVariable String dni) {
        return ResponseEntity.status(HttpStatus.OK).body(rolPorUsuarioService.findByDni(dni));
    }
}
