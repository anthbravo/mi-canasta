package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuariosPorFamilia")
public class UsuarioPorFamilia {

    @EmbeddedId
    private UsuarioPorFamiliaIdentity usuarioPorFamiliaIdentity;

    public UsuarioPorFamiliaIdentity getUsuarioPorFamiliaIdentity() {
        return usuarioPorFamiliaIdentity;
    }

    public void setUsuarioPorFamiliaIdentity(UsuarioPorFamiliaIdentity usuarioPorFamiliaIdentity) {
        this.usuarioPorFamiliaIdentity = usuarioPorFamiliaIdentity;
    }
}

//Registrar usuario  @Tra
