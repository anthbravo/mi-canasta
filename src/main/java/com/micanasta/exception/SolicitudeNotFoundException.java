package com.micanasta.exception;
import com.micanasta.dto.ExceptionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SolicitudeNotFoundException extends Throwable {
    public ExceptionDto exceptionDto;

    public SolicitudeNotFoundException() {
        exceptionDto = new ExceptionDto("SolicitudeNotFoundException",
                "No se encuentra la solicitud");
    }
}
