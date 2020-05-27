package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailWrongFormatException extends Exception {
    public ExceptionDto exceptionDto;

    public EmailWrongFormatException() {
        exceptionDto = new ExceptionDto("EmailWrongFormatException",
                "El correo no tiene un formato válido");
    }
}
