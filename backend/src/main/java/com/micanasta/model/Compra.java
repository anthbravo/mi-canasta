package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compras")
public class Compra {

    @EmbeddedId
    private CompraIdentity compraIdentity;

    @NotNull
    private float cantidad;

    @NotNull
    private Date fechaCompra;

    @NotNull
    private String dni;

    @NotNull
    private boolean confirmacion;
}
