package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historiales")
public class Historial {

    @EmbeddedId
    private HistorialIdentity historialIdentity;

    @NotNull
    private float cantidad;

    @NotNull
    private Date fechaCompra;

    @NotNull
    private String dni;
}
