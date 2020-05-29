package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginIncorrectException extends Exception {
    public ExceptionDto exceptionDto;

    public UserLoginIncorrectException() {
        exceptionDto = new ExceptionDto("UserLoginIncorrectException",
                "El usuario ingresado no corresponde a la contraseña brindada");
    }
}
