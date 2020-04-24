package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rolesPorUsuario")
public class RolPorUsuario {
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "usuario_dni",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "rolPerfil_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RolPerfil rolPerfil;
}
