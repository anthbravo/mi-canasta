package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyNotFoundException extends Exception {
    public ExceptionDto exceptionDto;

    public FamilyNotFoundException() {
        exceptionDto = new ExceptionDto("FamilyNotFoundException",
                "El grupo familiar no existe");
    }

}
