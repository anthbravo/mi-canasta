package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ExistingFamilyFoundException extends Exception{
    public ExceptionDto exceptionDto;

    public ExistingFamilyFoundException() {
        exceptionDto = new ExceptionDto("ExistingFamilyFoundException",
                "El nombre del grupo familiar ya existe");
    }
}
