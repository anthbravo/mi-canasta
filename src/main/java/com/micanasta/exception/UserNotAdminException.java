package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;

public class UserNotAdminException extends Exception {
    public ExceptionDto exceptionDto;

    public UserNotAdminException() {
        exceptionDto = new ExceptionDto("UserNotAdminException",
                "Usuario no reconocido como administrador");
    }
}