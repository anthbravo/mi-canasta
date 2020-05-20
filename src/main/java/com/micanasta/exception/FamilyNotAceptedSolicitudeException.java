package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;

public class FamilyNotAceptedSolicitudeException extends Exception {
    public ExceptionDto exceptionDto;

    public FamilyNotAceptedSolicitudeException() {
        exceptionDto = new ExceptionDto("FamilyNotAceptedSolicitudeException",
                "El grupo familiar no acepta solicitudes");
    }

}
