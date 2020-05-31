package com.micanasta.service;

import com.micanasta.dto.StockDto;
import com.micanasta.dto.StockUpdateDto;
import com.micanasta.dto.TiendaDto;
import java.util.List;

public interface TiendaService {
    TiendaDto getById(long id);
    List<StockDto> getStocksById(long id);
    StockDto updateStock(long idTienda, long idProducto, StockUpdateDto stockUpdateDto);
}