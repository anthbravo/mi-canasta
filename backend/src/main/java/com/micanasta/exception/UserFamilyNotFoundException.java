package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;

public class UserFamilyNotFoundException extends Exception{
    public ExceptionDto exceptionDto;

    public UserFamilyNotFoundException()
    {
        exceptionDto = new ExceptionDto("UserFamilyNotFoundException",
                "El usuario no pertenece a una familia");
    }

}
