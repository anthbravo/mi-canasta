package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TiendaUpdateDto {

    private String descripcion;
    private String direccion;
    private String latitud;
    private String longitud;
    private String horario;
    private String contrasena;
}
