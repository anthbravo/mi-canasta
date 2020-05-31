package com.micanasta.service.impl;

import com.micanasta.dto.StockDto;
import com.micanasta.dto.TiendaDto;
import com.micanasta.dto.converter.StockDtoConverter;
import com.micanasta.dto.converter.TiendaDtoConverter;
import com.micanasta.model.Stock;
import com.micanasta.repository.StockRepository;
import com.micanasta.repository.TiendaRepository;
import com.micanasta.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TiendaServiceimpl implements TiendaService {

    @Autowired
    TiendaRepository tiendaRepository;

    @Autowired
    TiendaDtoConverter tiendaDtoConverter;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockDtoConverter stockDtoConverter;

    @Override
    public TiendaDto getById(long id) {
        return tiendaDtoConverter.convertToDto(tiendaRepository.getById(id));
    }

    @Override
    public List<StockDto> getStocksById(long id){
        List<StockDto> stocksDto = new ArrayList<>();
        List<Stock> stocks = stockRepository.getByStockIdentityTiendaId(id);
        for(Stock stock : stocks){
            stocksDto.add(stockDtoConverter.convertToDto(stock));
        }
        return stocksDto;
    }
}
