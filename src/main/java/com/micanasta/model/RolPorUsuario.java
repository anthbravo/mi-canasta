package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rolesPorUsuario")
public class RolPorUsuario {

    @EmbeddedId
    private RolPorUsuarioIdentity rolPorUsuarioIdentity;

    public RolPorUsuarioIdentity getRolPorUsuarioIdentity() {
        return rolPorUsuarioIdentity;
    }

    public void setRolPorUsuarioIdentity(RolPorUsuarioIdentity rolPorUsuarioIdentity) {
        this.rolPorUsuarioIdentity = rolPorUsuarioIdentity;
    }
}
