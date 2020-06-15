package com.micanasta.controller;

import com.micanasta.dto.StockRequestDto;
import com.micanasta.exception.StockRequestNotFoundException;
import com.micanasta.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
