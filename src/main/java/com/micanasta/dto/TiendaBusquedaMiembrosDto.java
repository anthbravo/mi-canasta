package com.micanasta.dto;
import com.micanasta.model.RolPorUsuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class TiendaBusquedaMiembrosDto {

    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    public long rolId;
    public String descripción;
}
