package com.micanasta.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="usuarios")
public class Usuario {

    @Id
    @Column(unique = true)
    private String dni;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidoPat;

    @NotNull
    private String apellidoMat;

    @NotNull
    private String contrasena;

    @NotNull
    private String correoElectronico;

}

