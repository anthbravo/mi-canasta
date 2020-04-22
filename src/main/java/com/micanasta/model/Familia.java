package com.micanasta.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.naming.Name;
import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="familias")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFamilia;

    @NotNull
    private string nombreUnico;

    @Value("True")
    private boolean aceptacionSolicitudes;

    @NotNull
    private int cantidad;

}
