package com.micanasta.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class StockIdentity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tienda_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tienda tienda;
}
