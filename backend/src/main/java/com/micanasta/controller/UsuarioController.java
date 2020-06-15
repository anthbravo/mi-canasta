package com.micanasta.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.micanasta.dto.UsuarioAccesoDto;
import com.micanasta.dto.UsuarioDataDto;
import com.micanasta.dto.UsuarioLoginDto;
import com.micanasta.exception.*;
import com.micanasta.model.Familia;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.Tienda;
import com.micanasta.service.FamiliaService;
import com.micanasta.service.impl.*;
import com.micanasta.dto.UsuarioUpdateDto;
import com.micanasta.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class  UsuarioController {
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

            return ResponseEntity.status(201).body(usuarioService.GetDatosUsuario(usuarioLoginDto.dni,usuarioLoginDto.contrasena));
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
    @GetMapping("usuarios/{dni}")
    public ResponseEntity<?> GetUsuario(@PathVariable String dni){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findByDni(dni));
    }

    @GetMapping("usuarios/{dni}/usuariosporfamilia")
    public ResponseEntity<?> GetUsuarioFamilia(@PathVariable String dni){
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.GetUsuarioFamilia(dni));
        }
        catch(UserFamilyNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.exceptionDto);
        }
    }
    @DeleteMapping("usuarios/{dni}/familias/{idFamilia}")
    public ResponseEntity<?> cancelarSolicitud(@PathVariable("dni") String dni, @PathVariable("idFamilia") Long idFamilia ) throws SolicitudeNotFoundException{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.cancelarSolicitud(dni,idFamilia));
        } catch (SolicitudeNotFoundException solicitudeNotFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(solicitudeNotFoundException.exceptionDto);
        }
    }

}
