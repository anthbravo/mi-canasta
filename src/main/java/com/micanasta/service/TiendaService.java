package com.micanasta.service;

import com.micanasta.dto.*;
import com.micanasta.exception.UserAddedShopExceedLimitException;
import com.micanasta.exception.UserAddedShopIncorrectException;
import com.micanasta.exception.UserNotAdminException;
import com.micanasta.exception.UserNotFoundException;
import com.micanasta.model.RolPorUsuario;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TiendaService {
    TiendaDto getById(long id);
    List<StockDto> getStocksById(long id);
    StockDto updateStock(long idTienda, long idProducto, StockUpdateDto stockUpdateDto);
    TiendaUsuarioDto postUsuarioInTienda(String dni, long tiendaId)throws UserAddedShopIncorrectException, UserAddedShopExceedLimitException;
    RolPorUsuario asignarRolPorUsuario(String dni, Long id);
    List<RolPorPerfilListaDto> switchRolPerfil(String userDni, String adminDni, boolean cambiarRol) throws UserNotFoundException, UserNotAdminException;
    List<TiendaDto> getAllTiendas();
    TiendaInfoDto getTiendaInfo(long idTienda);
    List<TiendaBusquedaMiembrosDto> buscarMiembrosGrupoDistribuidoraPorTiendaId(long id);
}
