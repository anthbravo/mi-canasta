package com.micanasta.dto.converter;

import com.micanasta.dto.StockDto;
import com.micanasta.dto.StockRequestDto;
import com.micanasta.model.Stock;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockRequestDtoConverter {
    private final ModelMapper modelMapper;

    public StockRequestDto convertToDto(Stock stock) {
        StockRequestDto stockRequestDto = new StockRequestDto();
        stockRequestDto.setCantidad(stock.getCantidad());
        stockRequestDto.setProductoId(stock.getStockIdentity().getProducto().getId());
        stockRequestDto.setTiendaId(stock.getStockIdentity().getTienda().getId());
        return stockRequestDto;
    }

    public Stock convertToEntity(StockRequestDto stockRequestDto) {
        return modelMapper.map(stockRequestDto, Stock.class);
    }
}
