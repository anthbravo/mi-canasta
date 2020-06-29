package com.micanasta.controller;
import com.micanasta.dto.*;
import com.micanasta.exception.*;
import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.dto.StockUpdateDto;
import com.micanasta.dto.StockUpdateDto;
import com.micanasta.exception.UserAddedShopExceedLimitException;
import com.micanasta.exception.UserAddedShopIncorrectException;
import com.micanasta.model.UsuarioPorTienda;
import com.micanasta.service.TiendaService;
import com.micanasta.service.UsuarioService;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequiredArgsConstructor
public class TiendaController {
    @Autowired
    TiendaService tiendaService;

    @GetMapping("/tiendas/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok().body(tiendaService.getById(id));
    }

    @GetMapping("/tiendas/{id}/limite")
    public ResponseEntity<?> getLimiteTienda(@PathVariable long id) {
        return ResponseEntity.ok().body(tiendaService.getLimiteTienda(id));
    }

    @GetMapping("/tiendas/{idTienda}/stocks")
    public ResponseEntity<?> getStocksById(@PathVariable long idTienda) {
        try {
            return ResponseEntity.ok().body(tiendaService.getStocksById(idTienda));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/tiendas/{idTienda}/productos/{idProducto}/stocks")
    public ResponseEntity<?> UpdateStock(@PathVariable long idTienda, @PathVariable long idProducto,
                                         @RequestBody StockUpdateDto stockUpdateDto) {
        try {
            return ResponseEntity.ok().body(tiendaService.updateStock(idTienda, idProducto, stockUpdateDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/tiendas/{idTienda}/usuario/{dni}/usuariosportienda")
    public ResponseEntity<?> postUsuarioInTienda(long idTienda, String dni) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(tiendaService.postUsuarioInTienda(idTienda, dni));
        } catch (UserAddedShopExceedLimitException userAdded) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userAdded.exceptionDto);
        } catch (UserAddedShopIncorrectException userIncorrect) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userIncorrect.exceptionDto);
        }
    }

    @GetMapping("/tiendas/{idTienda}/usuarios")
    public ResponseEntity<?> buscarMiembrosGrupoDistribuidoraPorTiendaId(@PathVariable("idTienda") long id) {
        List<TiendaBusquedaMiembrosDto> miembrosGrupoDistruibuidoraPorTienda = tiendaService.buscarMiembrosGrupoDistribuidoraPorTiendaId(id);
        return ResponseEntity.status(miembrosGrupoDistruibuidoraPorTienda != null ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(miembrosGrupoDistruibuidoraPorTienda);
    }

    @GetMapping("/tiendas")
    public ResponseEntity<?> getAllTiendas() {
        try {
            return ResponseEntity.ok().body(tiendaService.getAllTiendas());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/tiendas/{idTienda}/{dni}/updateTienda")
    public ResponseEntity<?> updateTienda(@PathVariable Long idTienda, @PathVariable String dni,
                                          @RequestBody TiendaUpdateDto tienda){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tiendaService.updateTienda(idTienda, dni, tienda));
        }
        catch (ActualPasswordNotMatchException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.exceptionDto);
        }
    }

    @GetMapping("/tiendas/RolesPorPerfi/{userDni}/{dniAdmi}/{cambiarRol}")
    public ResponseEntity<?> switchRolPerfil(String userDni, String adminDni, @PathVariable boolean cambiarRol ) {


        try {
            return ResponseEntity.status(HttpStatus.OK).body(tiendaService.switchRolPerfil(userDni,adminDni,cambiarRol));
        }catch (UserNotFoundException userNotFoundExeption) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userNotFoundExeption.exceptionDto);
        }catch (UserNotAdminException userNotAdminException)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userNotAdminException);
        }

    }


    @GetMapping("/tiendas/{idTienda}/stockNombre")
    public ResponseEntity<?> getTiendaInfo(@PathVariable long idTienda) {

        TiendaInfoDto tiendaInfoDto = tiendaService.getTiendaInfo(idTienda);
        return ResponseEntity.status(tiendaInfoDto != null ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(tiendaInfoDto);

    }
}


