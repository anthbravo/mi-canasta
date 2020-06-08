package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException  extends Exception {
    public ExceptionDto exceptionDto;

    public UserNotFoundException() {
        exceptionDto = new ExceptionDto("UserNotFoundException",
                "El usuario no pertenece al grupo familiar");
    }

}
