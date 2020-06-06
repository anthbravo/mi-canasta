package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TiendaInfoDto {


    private String descripcion;

    private String direccion;

    private String horario;

    private List<StockInfoDto> stock;
}
