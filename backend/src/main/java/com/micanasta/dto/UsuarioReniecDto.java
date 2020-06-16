package com.micanasta.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioReniecDto {
    public String dni;
    public String nombre1;
    public String nombre2;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public char genero;
    public Date fechaNacimiento;
}
