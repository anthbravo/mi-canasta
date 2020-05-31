package com.micanasta.controller;

import com.micanasta.service.TiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TiendaController {
    @Autowired
    TiendaService tiendaService;

    @GetMapping("/tiendas/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        return ResponseEntity.ok().body(tiendaService.getById(id));
    }

    @GetMapping("/tiendas/{idTienda}/stocks")
    public ResponseEntity<?> getStocksById(@PathVariable long idTienda){
        try {
            return ResponseEntity.ok().body(tiendaService.getStocksById(idTienda));
        }
        catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
