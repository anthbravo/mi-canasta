package com.micanasta.controller;

import com.micanasta.model.Familia;
import com.micanasta.model.Solicitud;
import com.micanasta.model.UsuarioPorFamilia;
import com.micanasta.service.FamiliaService;
import com.micanasta.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @GetMapping("/familias/{familiaNombre}/usuarios")
    public Optional<UsuarioPorFamilia> getUsuariosByNombre(@PathVariable String familiaNombre){
        Optional<UsuarioPorFamilia> result = familiaService.getUsuariosPorFamilia(familiaNombre);
        return result;
    }
}
