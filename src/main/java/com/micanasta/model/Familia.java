package com.micanasta.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;




import javax.persistence.*;
import javax.validation.constraints.NotNull;

@data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="familias")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "familia_id")
    private long idFamilia;

    @NotNull
    @Column(unique = true)
    private string nombreUnico;

    private boolean aceptacionSolicitudes = true;

    @NotNull
    private int cantidad;

}
