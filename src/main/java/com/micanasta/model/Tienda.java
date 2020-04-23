package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tiendas")
public class Tienda {

    @Id
    @Column(name = "tienda_id")
    private long idTienda;

    @NotNull
    private string descripcion;

    @NotNull
    private string direccion;

    @NotNull
    private string latitud;

    @NotNull
    private string longitud;

    @NotNull
    private string horario;
}
