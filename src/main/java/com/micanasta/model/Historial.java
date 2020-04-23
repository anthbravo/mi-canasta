package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historiales")
public class Historial {
    private Familia idFamilia;
    private Tienda idTienda;
    private Producto idProducto;
    private float cantidad;
    private Date fechaCompra;
    private string dni;
}
