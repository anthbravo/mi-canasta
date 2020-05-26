package com.micanasta.dto;
import com.micanasta.model.RolPerfil;
import com.micanasta.model.RolPorUsuarioIdentity;
import com.micanasta.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EditarRolesFamiliaDTO {
    private String nombreFamilia;
    private String dni;
}
