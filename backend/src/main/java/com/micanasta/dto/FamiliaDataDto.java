package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamiliaDataDto {
    public Long id;
    public String nombreUnico;
    public Boolean aceptacionSolicitudes;
    public int cantidad;
}
