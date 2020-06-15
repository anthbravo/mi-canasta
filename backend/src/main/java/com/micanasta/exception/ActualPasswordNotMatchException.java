package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualPasswordNotMatchException extends Exception {
    public ExceptionDto exceptionDto;

    public ActualPasswordNotMatchException() {
        exceptionDto = new ExceptionDto("ActualPasswordNotMatchException",
                "La actual contraseña no coincide");
    }
}
