package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudeTroubleException extends Exception{
    public ExceptionDto exceptionDto;

    public SolicitudeTroubleException()
    {
        exceptionDto = new ExceptionDto("SolicitudeTroubleException",
                "Ha ocurrido un problema al realizar su operacion");
    }

}
