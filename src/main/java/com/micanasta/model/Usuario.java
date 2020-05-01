package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

