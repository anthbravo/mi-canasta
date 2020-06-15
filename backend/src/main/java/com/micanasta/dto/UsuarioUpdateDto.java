package com.micanasta.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDto {
    public String correoElectronico;

    public String contrasena;

    public String nuevaContrasena;

    public String repetirContrasena;
}
