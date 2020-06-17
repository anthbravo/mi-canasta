package com.micanasta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.dto.UsuarioLoginDto;
import com.micanasta.dto.UsuarioUpdateDto;
import com.micanasta.exception.ActualPasswordNotMatchException;
import com.micanasta.exception.EmailWrongFormatException;
import com.micanasta.exception.NewPasswordNotMatchException;
import com.micanasta.exception.SolicitudeNotFoundException;
import com.micanasta.exception.UserFamilyNotFoundException;
import com.micanasta.exception.UserLoginIncorrectException;
import com.micanasta.exception.UserLoginNotFoundException;
import com.micanasta.service.impl.RolPorUsuarioServiceImpl;
import com.micanasta.service.impl.UsuarioPorFamiliaServiceImpl;
import com.micanasta.service.impl.UsuarioPorTiendaServiceImpl;
import com.micanasta.service.impl.UsuarioServiceImpl;

@RestController
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
