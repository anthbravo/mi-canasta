package com.micanasta.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Embeddable
public class StockIdentity implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tienda_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tienda tienda;
}
