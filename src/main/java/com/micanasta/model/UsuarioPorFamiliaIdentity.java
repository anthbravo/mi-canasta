package com.micanasta.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UsuarioPorFamiliaIdentity implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "familia_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Familia familia;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}
