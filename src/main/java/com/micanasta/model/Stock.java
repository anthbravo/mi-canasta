package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tienda_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tienda tienda;

    @NotNull
    private float cantidad;
}
