package com.micanasta.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class UsuarioPorTiendaIdentity implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tienda_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tienda tienda;
}
