package com.micanasta.controller;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.dto.FamiliaNoIdDto;
import com.micanasta.exception.*;
import com.micanasta.model.Familia;
import com.micanasta.service.FamiliaService;
import com.micanasta.model.Familia;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequiredArgsConstructor
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @PostMapping("/familias")
    public ResponseEntity<?> crearFamilia(@Valid @RequestBody CrearFamiliaDTO familiaDTO) {
        try {
             familiaService.crearGrupoFamiliar(familiaDTO);
        } catch (ExistingFamilyFoundException existingFamilyFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(existingFamilyFoundException.exceptionDto);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Se ha creado el grupo familiar");
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

    @PutMapping("/familias/{dni}/rolesPorUsuario")
    public ResponseEntity<?> cambiarRolUsuario(@PathVariable String dni) throws UserNotFoundException{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(familiaService.cambiarRolUsuario(dni));
        } catch (UserNotFoundException userNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userNotFoundException.exceptionDto);
        }
    }
}
