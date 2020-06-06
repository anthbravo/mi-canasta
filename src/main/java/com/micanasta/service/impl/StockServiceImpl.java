package com.micanasta.service.impl;

import com.micanasta.dto.StockRequestDto;
import com.micanasta.dto.converter.StockRequestDtoConverter;
import com.micanasta.exception.StockRequestNotFoundException;
import com.micanasta.model.Stock;
import com.micanasta.repository.StockRepository;
import com.micanasta.service.StockService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    StockRequestDtoConverter stockRequestDtoConverter;

    public List<StockRequestDto> getProductsByRequest(long productId, float cantidad) throws StockRequestNotFoundException{
        List<Stock> stockList = stockRepository.findByProductIdAndCantidad(productId,cantidad);

        if (stockList != null) {
            List<StockRequestDto> listStock = new ArrayList<StockRequestDto>();
            for (Stock item:stockList)
            {
             listStock.add(stockRequestDtoConverter.convertToDto(item));
            }
            return listStock;}
        throw new StockRequestNotFoundException();
    }
}
