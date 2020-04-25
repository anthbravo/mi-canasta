package com.micanasta.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Embeddable
public class RolPorUsuarioIdentity implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rolPerfil_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RolPerfil rolPerfil;
}
