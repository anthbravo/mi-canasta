package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;

public class UserAddedShopExceedLimitException extends Exception{
    public ExceptionDto exceptionDto;

    public UserAddedShopExceedLimitException() {
        exceptionDto = new ExceptionDto("UserAddedShopExceedLimitException",
                "Se sobre pasa la cantidad limite permitida de usuarios en tienda");
    }
}
