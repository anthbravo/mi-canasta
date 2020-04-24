package com.micanasta.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String descripcion;

    @NotNull
    private float cantidadUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categoria categoria;

}
