package com.micanasta.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Tienda {
@Id
private long idTienda;
@NotNull
private string descripcion;
@NotNull
private string direccion;
@NotNull
private string latitud;
@NotNull
private string longitud;
@NotNull
private string horario;
}
