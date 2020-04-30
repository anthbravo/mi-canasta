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
@Table(name = "familias")

public class Familia {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "No puede dejar campos vacíos")
    @Column(unique = true)
    private String nombreUnico;
    private boolean aceptacionSolicitudes = true;

    @NotNull (message = "No puede dejar campos vacíos")
    private int cantidad;

}
