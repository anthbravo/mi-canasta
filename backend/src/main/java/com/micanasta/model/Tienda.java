package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tiendas")
public class Tienda {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String descripcion;

    @NotNull
    private String direccion;

    @NotNull
    private int limite;

    @NotNull
    private String latitud;

    @NotNull
    private String longitud;

    @NotNull
    private String horario;
}
