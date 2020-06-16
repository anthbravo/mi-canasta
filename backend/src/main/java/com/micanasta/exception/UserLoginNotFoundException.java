package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginNotFoundException extends Exception {
    public ExceptionDto exceptionDto;

    public UserLoginNotFoundException() {
        exceptionDto = new ExceptionDto("UserLoginNotFoundException",
                "El usuario ingresado no se encuentra registrado en la institución de identidad");
    }
}
