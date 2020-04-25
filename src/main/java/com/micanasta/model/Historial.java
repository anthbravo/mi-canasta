package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import net.bytebuddy.description.type.TypeList;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
