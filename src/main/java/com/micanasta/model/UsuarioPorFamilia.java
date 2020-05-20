package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuariosPorFamilia")
public class UsuarioPorFamilia {

    @EmbeddedId
    private UsuarioPorFamiliaIdentity usuarioPorFamiliaIdentity;

}
