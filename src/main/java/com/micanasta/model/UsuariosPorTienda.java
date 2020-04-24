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
@Table(name = "usuariosPorTienda")
public class UsuariosPorTienda {
    @ManyToOne(fetch= FetchType.LAZY,optional=false)
    @JoinColumn(name="usuario_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne(fetch= FetchType.LAZY,optional=false)
    @JoinColumn(name="tienda_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tienda tienda;
}
