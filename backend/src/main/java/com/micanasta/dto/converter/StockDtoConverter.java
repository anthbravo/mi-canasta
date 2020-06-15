package com.micanasta.dto.converter;

import com.micanasta.dto.CategoriaDto;
import com.micanasta.dto.StockDto;
import com.micanasta.model.Categoria;
import com.micanasta.model.Stock;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockDtoConverter {

    private final ModelMapper modelMapper;

    public StockDto convertToDto(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setCantidad(stock.getCantidad());
        stockDto.setProductoId(stock.getStockIdentity().getProducto().getId());
        stockDto.setTiendaId(stock.getStockIdentity().getTienda().getId());
        return stockDto;
    }

    public Stock convertToEntity(StockDto stockDto) {
        return modelMapper.map(stockDto, Stock.class);
    }
}
