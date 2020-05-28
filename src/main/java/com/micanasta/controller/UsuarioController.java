package com.micanasta.controller;

import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioLoginDto;
import com.micanasta.dto.UsuarioUpdateDto;
import com.micanasta.exception.ActualPasswordNotMatchException;
import com.micanasta.exception.EmailWrongFormatException;
import com.micanasta.exception.NewPasswordNotMatchException;
import com.micanasta.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("usuarios")
    public ResponseEntity<?> ValidarIngreso(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        UsuarioAccesoDto usuarioAccesoDto = usuarioService.ValidateLogin(usuarioLoginDto.dni, usuarioLoginDto.contrasena);
        if (usuarioAccesoDto.dni == "NotFound") {
            return ResponseEntity.status(401).body(usuarioAccesoDto);
        }
        if (usuarioAccesoDto.dni == "NotExist") {
            return ResponseEntity.status(404).body(usuarioAccesoDto);
        } else {
            return ResponseEntity.ok().body(usuarioAccesoDto);
        }
    }
    @PutMapping("usuarios/{dni}")
    public ResponseEntity<?> Update(@PathVariable String dni, @RequestBody UsuarioUpdateDto usuarioUpdateDto) throws EmailWrongFormatException, NewPasswordNotMatchException, ActualPasswordNotMatchException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(dni, usuarioUpdateDto));
        }
        catch (EmailWrongFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.exceptionDto);
        }
        catch (ActualPasswordNotMatchException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.exceptionDto);
        }
        catch (NewPasswordNotMatchException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.exceptionDto);
        }
    }
}
