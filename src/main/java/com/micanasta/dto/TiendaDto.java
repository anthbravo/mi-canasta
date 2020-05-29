package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TiendaDto {

    private long id;

    private String descripcion;

    private String direccion;

    private int limite;

    private String latitud;

    private String longitud;

    private String horario;
}
