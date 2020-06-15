package com.micanasta.controller;

import com.micanasta.service.CategoriaService;
import com.micanasta.service.RolPorUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class RolesPorUsuarioController {
    @Autowired
    private RolPorUsuarioService rolPorUsuarioService;

    @GetMapping("/rolesporusuario/{dni}")
    public ResponseEntity<?> getById(@PathVariable String dni) {
        return ResponseEntity.status(HttpStatus.OK).body(rolPorUsuarioService.findByDni(dni));
    }
}
