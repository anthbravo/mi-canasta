package com.micanasta.dto;

import com.micanasta.model.Categoria;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductoDto {

    private long id;

    private String descripcion;

    private float cantidadUnit;

    private long categoriaId;
}
