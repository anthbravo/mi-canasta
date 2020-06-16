package com.micanasta.service;

import com.micanasta.dto.StockRequestDto;
import com.micanasta.exception.StockRequestNotFoundException;

import java.util.List;

public interface StockService {
    List<StockRequestDto> getProductsByRequest(long productId, float cantidad) throws StockRequestNotFoundException;
}
