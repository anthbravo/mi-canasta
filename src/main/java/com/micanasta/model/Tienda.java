package com.micanasta.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
