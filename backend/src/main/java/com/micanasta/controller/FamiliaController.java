package com.micanasta.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.exception.ExistingFamilyFoundException;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.exception.UserNotAdminException;
import com.micanasta.exception.UserNotFoundException;
import com.micanasta.service.FamiliaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @PostMapping("/familias")
    public ResponseEntity<?> crearFamilia(@Valid @RequestBody CrearFamiliaDTO familiaDTO) {
        try {
        	return ResponseEntity.status(HttpStatus.OK).body(familiaService.crearGrupoFamiliar(familiaDTO));
        } catch (ExistingFamilyFoundException existingFamilyFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(existingFamilyFoundException.exceptionDto);
        }
    }

    @GetMapping("/familias/{nombreFamilia}/usuarios")
    public ResponseEntity<?> buscarMiembrosGrupoFamiliarPorNombreFamilia(@PathVariable("nombreFamilia") String nombreFamilia) {

        List<FamiliaBusquedaMiembrosDto> miembrosGrupoFamiliarPorFamilia = familiaService.buscarMiembrosGrupoFamiliarPorNombreFamilia(nombreFamilia);

        return ResponseEntity.status(miembrosGrupoFamiliarPorFamilia != null ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(miembrosGrupoFamiliarPorFamilia);

    }

    @GetMapping("/familias/{nombreFamilia}/compras")
    public ResponseEntity<?> getCompra(@PathVariable String nombreFamilia, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaInicio,
                                          @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")  Date fechaFin){
        return ResponseEntity.status(HttpStatus.OK).body(familiaService.getCompra(nombreFamilia, fechaInicio,
                fechaFin));
    }

    @PutMapping("/familias/{idFamilia}")
    public ResponseEntity<?> desactivarSolicitudes(@PathVariable("idFamilia")Long idFamilia){
        try{
            familiaService.desactivarSolicitudes(idFamilia);
        } catch (FamilyNotFoundException familyNotFoundException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(familyNotFoundException.exceptionDto);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Se desactivó realizar solicitudes y se eliminaron las existentes");
    }

    @DeleteMapping("/familias/{nombreFamilia}/usuarios/{dni}")
    public ResponseEntity<?> deleteUsuarioDeFamilia(@PathVariable String nombreFamilia, @PathVariable String dni ){
            try {
                return ResponseEntity.status(HttpStatus.OK).body(familiaService.Remove(dni));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

    }

    //Se está reusando la exception familyNotFoundException
    @GetMapping("familias/{familiaId}")
    public ResponseEntity<?> getFamilia(@PathVariable Long familiaId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(familiaService.getById(familiaId));
        }catch(FamilyNotFoundException familyNotFoundException){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(familyNotFoundException.exceptionDto);
        }
    }

    @PutMapping("/familias/{nombreFamilia}/usuarios/{dni}")
    public ResponseEntity<?> editarRolUsuarioFamilia(@PathVariable String dni, String adminDni ) throws UserNotFoundException, UserNotAdminException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(familiaService.editarRolUsuarioFamilia(dni, adminDni));
        } catch (UserNotFoundException userNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userNotFoundException.exceptionDto);
        } catch (UserNotAdminException userNotAdminException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userNotAdminException.exceptionDto);
        }
    }
}
