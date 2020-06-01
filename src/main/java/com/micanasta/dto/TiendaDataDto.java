package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TiendaDataDto {
    public long id;
    public String descripcion;
    public String direccion;
    public String Latitud;
    public String longitud;
    public String horario;
}
