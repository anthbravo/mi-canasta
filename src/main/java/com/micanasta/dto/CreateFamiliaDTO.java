package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFamiliaDTO {
    private String nombreUnico;
    private boolean aceptacionSolicitudes;
    private int cantidad;

}
