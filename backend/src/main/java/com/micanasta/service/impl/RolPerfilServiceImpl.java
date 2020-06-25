package com.micanasta.service.impl;

import com.micanasta.dto.CambioRolPerfilDto;
import com.micanasta.model.RolPerfil;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.model.RolPorUsuarioIdentity;
import com.micanasta.model.Usuario;
import com.micanasta.repository.RolPerfilRepository;
import com.micanasta.repository.RolPorUsuarioRepository;
import com.micanasta.service.RolPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolPerfilServiceImpl implements RolPerfilService {

    @Autowired
    RolPerfilRepository rolPerfilRepository;
    @Autowired
    RolPorUsuarioRepository rolPorUsuarioRepository;

    public CambioRolPerfilDto EditRolPerfil(String dni, List<Long> ids ){

            CambioRolPerfilDto cambioRolPerfilDto = new CambioRolPerfilDto();
        for (Long id :ids) {
            RolPerfil rolPerfil = new RolPerfil();
            rolPerfil.setId(id); // 1--> UsuarioPorFamilia, 2--> UsuarioPorTienda, 3--> TiendaAdmi, 4-->TiendaNoAdmi

            Usuario usuario = new Usuario();
            usuario.setDni(dni);

            RolPorUsuarioIdentity rolPorUsuarioIdentity = new RolPorUsuarioIdentity();
            rolPorUsuarioIdentity.setUsuario(usuario);
            rolPorUsuarioIdentity.setRolPerfil(rolPerfil);

            RolPorUsuario rolPorUsuario = new RolPorUsuario();
            rolPorUsuario.setRolPorUsuarioIdentity(rolPorUsuarioIdentity);

            rolPorUsuarioRepository.save(rolPorUsuario);

        }
        cambioRolPerfilDto.setDni(dni);
        cambioRolPerfilDto.setId(ids);
        return cambioRolPerfilDto;

    }
}
