package com.micanasta.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TiendaBusquedaMiembrosDto {

    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private RolPorUsuarioDataDto rolPorUsuarioDataDto;
}
