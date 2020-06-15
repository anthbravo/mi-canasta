package com.micanasta.exception;

import com.micanasta.dto.ExceptionDto;

public class UserToDeleteIsAdminException extends Exception {
    public ExceptionDto exceptionDto;

    public UserToDeleteIsAdminException() {
        exceptionDto = new ExceptionDto("UserToDeleteIsAdminException",
                "No se puede eliminar a un administrador");
    }
}