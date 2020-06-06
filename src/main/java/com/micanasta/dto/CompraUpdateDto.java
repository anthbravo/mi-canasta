package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompraUpdateDto {

    private float cantidad;

    private Date fechaCompra;

    private String dni;

    private boolean confirmacion;

    private long tiendaId;

    private long familiaId;

    private long productoId;
}