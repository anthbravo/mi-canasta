package com.micanasta.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.micanasta.dto.*;
import com.micanasta.exception.UserLoginIncorrectException;
import com.micanasta.exception.UserLoginNotFoundException;
import com.micanasta.model.Familia;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.Tienda;
import com.micanasta.service.FamiliaService;
import com.micanasta.service.impl.*;
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
    @Autowired
    private UsuarioPorFamiliaServiceImpl usuarioPorFamiliaService;
    @Autowired
    private UsuarioPorTiendaServiceImpl usuarioPorTiendaService;
    @Autowired
    private RolPorUsuarioServiceImpl rolPorUsuarioService;

    @PostMapping("usuarios")
    public ResponseEntity<?> ValidarIngreso(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        try {
            UsuarioAccesoDto usuarioAccesoDto = usuarioService.ValidateLogin(usuarioLoginDto.dni,
                    usuarioLoginDto.contrasena);
            UsuarioDataDto usuarioDataDto = new UsuarioDataDto();
            usuarioDataDto.setUsuarioAccesoDto(usuarioAccesoDto);
            usuarioDataDto.setFamilia(usuarioPorFamiliaService.findFamiliaById(usuarioLoginDto.dni));
            usuarioDataDto.setTienda(usuarioPorTiendaService.findTiendaById(usuarioLoginDto.dni));
            usuarioDataDto.setRolPorUsuario(rolPorUsuarioService.findByDni(usuarioLoginDto.dni));
            return ResponseEntity.status(201).body(usuarioDataDto);
        } catch (UserLoginNotFoundException userLoginNotFoundException) {
            return ResponseEntity.status(400).body(userLoginNotFoundException.exceptionDto);
        } catch (UserLoginIncorrectException userLoginIncorrectException) {
            return ResponseEntity.status(400).body(userLoginIncorrectException.exceptionDto);
        }
    }

    @PutMapping("usuarios/{dni}")
    public ResponseEntity<?> Update(@PathVariable String dni, @RequestBody UsuarioUpdateDto usuarioUpdateDto)
            throws EmailWrongFormatException, NewPasswordNotMatchException, ActualPasswordNotMatchException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(dni, usuarioUpdateDto));
        } catch (EmailWrongFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.exceptionDto);
        } catch (ActualPasswordNotMatchException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.exceptionDto);
        } catch (NewPasswordNotMatchException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.exceptionDto);
        }
    }

    @PutMapping("usuarios/{dni}/tiendas/{idTienda}")
    public ResponseEntity<?> updateTienda(@PathVariable String dni, @PathVariable Long idTienda,
                                          @RequestBody TiendaUpdateDto tienda){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.updateTienda(dni, idTienda, tienda));
        }
        catch (ActualPasswordNotMatchException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.exceptionDto);
        }
    }
}
