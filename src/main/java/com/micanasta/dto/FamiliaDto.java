package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FamiliaDto {
    private long id;
    private String nombreUnico;
    private boolean aceptacionSolicitudes = true;
}
