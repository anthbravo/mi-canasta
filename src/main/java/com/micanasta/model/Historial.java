package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historiales")
public class Historial {
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "familia_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Familia familia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tienda_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tienda tienda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producto_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;

    @NotNull
    private float cantidad;

    @NotNull
    private Date fechaCompra;

    @NotNull
    private String dni;
}
