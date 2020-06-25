package com.micanasta.controller;

import com.micanasta.service.RolPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RolPerfilController {
    @Autowired
    private RolPerfilService rolPerfilService;

    @PutMapping("/rolesporperfil/usuarios/{dni}/{ids}")
    public ResponseEntity<?> SwitchRolPerfil(@PathVariable String dni, List<Long> ids) {
        return ResponseEntity.status(HttpStatus.OK).body(rolPerfilService.EditRolPerfil(dni,ids));
    }

}
