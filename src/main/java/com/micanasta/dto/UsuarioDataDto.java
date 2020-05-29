package com.micanasta.dto;

import com.micanasta.model.Familia;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.Tienda;
import com.micanasta.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDataDto
{
    public UsuarioAccesoDto usuarioAccesoDto;
    public Familia familia;
    public Tienda tienda;
    public RolPorUsuario rolPorUsuario;
}
