package com.micanasta.model;

import lombok.*;

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
