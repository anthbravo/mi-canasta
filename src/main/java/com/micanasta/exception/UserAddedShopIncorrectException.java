package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;

public class UserAddedShopIncorrectException extends Exception{
    public ExceptionDto exceptionDto;

    public UserAddedShopIncorrectException() {
        exceptionDto = new ExceptionDto("UserAddedShopIncorrectException",
                "El DNI ingresado no es válido para ser agregado");
    }
}
