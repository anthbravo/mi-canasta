package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {

    public ExceptionDto(String exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public String exception;
    public String message;

}
