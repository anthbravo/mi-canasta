package com.micanasta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micanasta.dto.StockRequestDto;
import com.micanasta.exception.StockRequestNotFoundException;
import com.micanasta.service.StockService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StockController {

    @Autowired
    private StockService stockService;


    @GetMapping("stock")
    ResponseEntity<?> GetStock(@RequestParam(value="productoId") long productId, @RequestParam(value="cantidad") float cantidad){
        try{
            List<StockRequestDto> stockRequestDto = stockService.getProductsByRequest(productId,cantidad);
            return ResponseEntity.status(HttpStatus.OK).body(stockRequestDto);
        }catch(StockRequestNotFoundException stock){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(stock.exceptionDto);
        }
    }
}
