package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;

public class UserOnlyAdminException extends Exception {
    public ExceptionDto exceptionDto;

    public UserOnlyAdminException() {
        exceptionDto = new ExceptionDto("UserOnlyAdminException",
                "Debe asignar otro administrador para poder salir del grupo familiar");
    }
}
