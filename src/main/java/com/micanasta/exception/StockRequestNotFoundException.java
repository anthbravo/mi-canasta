package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;

public class StockRequestNotFoundException extends Exception{
    public ExceptionDto exceptionDto;

    public StockRequestNotFoundException()
    {
        exceptionDto = new ExceptionDto("StockRequestNotFoundException",
                "No se ha encontrado bajo los parametros requeridos");
    }
}
