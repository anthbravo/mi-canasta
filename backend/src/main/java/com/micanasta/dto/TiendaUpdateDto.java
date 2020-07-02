package com.micanasta.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TiendaUpdateDto {
    public String descripcion;

    public String contrasena;

    private String direccion;

    private String latitud;

    private String longitud;

    private String horario;
}
