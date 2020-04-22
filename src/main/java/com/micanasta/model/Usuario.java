package com.micanasta.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="usuarios")

public class Usuario {

    @Id
    private string dni;

    @NotNull
    private string nombre;
    @NotNull
    private string apellidoPat;
    @NotNull
    private string apellidoMat;
    @NotNull
    private string contrasena;
    @NotNull
    private string correoElectronico;

    }
}

