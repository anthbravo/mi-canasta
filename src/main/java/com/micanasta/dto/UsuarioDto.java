package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioDto {

    public String dni;
    public String nombre;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String contrasena;
    public String correoElectronico;
    public char genero;
    public Date fechaNacimiento;
}
