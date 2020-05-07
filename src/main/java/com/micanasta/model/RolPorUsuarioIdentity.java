package com.micanasta.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RolPorUsuarioIdentity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rolPerfil_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RolPerfil rolPerfil;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RolPerfil getRolPerfil() {
        return rolPerfil;
    }

    public void setRolPerfil(RolPerfil rolPerfil) {
        this.rolPerfil = rolPerfil;
    }
}
