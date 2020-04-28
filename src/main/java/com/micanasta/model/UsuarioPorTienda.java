package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuariosPorTienda")
public class UsuarioPorTienda {

    @EmbeddedId
    private UsuarioPorTiendaIdentity usuarioPorTiendaIdentity;
}
