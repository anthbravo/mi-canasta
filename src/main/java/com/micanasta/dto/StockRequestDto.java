package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRequestDto {
    public long productoId;
    public long tiendaId;
    public float cantidad;
}
