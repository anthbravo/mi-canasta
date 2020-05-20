package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {

    public ExceptionDto(String exception, String description) {
        this.exception = exception;
        this.description = description;
    }

    public String exception;
    public String description;

}
