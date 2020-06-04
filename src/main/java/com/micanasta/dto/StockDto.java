package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockDto {
    private long tiendaId;
    private long productoId;
    private float cantidad;
}