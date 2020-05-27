package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewPasswordNotMatchException extends Exception {
    public ExceptionDto exceptionDto;

    public NewPasswordNotMatchException() {
        exceptionDto = new ExceptionDto("NewPasswordNotMatchException",
                "La nueva contraseña no coincide con la verificación");
    }
}
