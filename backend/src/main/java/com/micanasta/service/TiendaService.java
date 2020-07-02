package com.micanasta.service;

import com.micanasta.dto.*;
import com.micanasta.exception.*;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.UsuarioPorTienda;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TiendaService {
    TiendaDto getById(long id);
    List<StockDto> getStocksById(long id);
    StockDto updateStock(long idTienda, long idProducto, StockUpdateDto stockUpdateDto);
    TiendaUsuarioDto postUsuarioInTienda(long idTienda, String dni)throws UserAddedShopIncorrectException, UserAddedShopExceedLimitException;
    RolPorUsuario asignarRolPorUsuario(String dni, Long id);
    UsuarioPorTienda cambiarRolUsuario(String dni) throws UserNotFoundException;
    List<TiendaDto> getAllTiendas();
    TiendaInfoDto getTiendaInfo(long idTienda);
    List<TiendaBusquedaMiembrosDto> buscarMiembrosGrupoDistribuidoraPorTiendaId(long id);
    TiendaLimiteDto getLimiteTienda(long id);
    TiendaDto updateTienda(long idTienda, String dni, TiendaUpdateDto tiendaUpdateDto) throws ActualPasswordNotMatchException;
}
