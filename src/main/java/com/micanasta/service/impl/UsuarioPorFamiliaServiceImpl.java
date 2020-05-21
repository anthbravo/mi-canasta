package com.micanasta.service.impl;

import com.micanasta.dto.UsuarioPorFamiliaDto;
import com.micanasta.dto.converter.UsuarioPorFamiliaDtoConverter;
import com.micanasta.model.Usuario;
import com.micanasta.model.UsuarioPorFamilia;
import com.micanasta.repository.RolPorUsuarioRepository;
import com.micanasta.repository.UsuarioPorFamiliaRepository;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.UsuarioPorFamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioPorFamiliaServiceImpl implements UsuarioPorFamiliaService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioPorFamiliaRepository usuarioPorFamiliaRepository;

    @Autowired
    UsuarioPorFamiliaDtoConverter usuarioPorFamiliaDtoConverter;

    @Autowired
    RolPorUsuarioRepository rolPorUsuarioRepository;

    @Override
    public UsuarioPorFamiliaDto Remove(String adminDni, String userDni) {

        Optional<UsuarioPorFamilia> usuarioPorFamilia =
                usuarioPorFamiliaRepository.findByUsuarioPorFamiliaIdentityUsuarioDni(userDni);

        UsuarioPorFamilia usuario =new UsuarioPorFamilia();
        usuario.getUsuarioPorFamiliaIdentity().setFamilia(usuarioPorFamilia.get().getUsuarioPorFamiliaIdentity().getFamilia());
        usuario.getUsuarioPorFamiliaIdentity().setUsuario(usuarioPorFamilia.get().getUsuarioPorFamiliaIdentity().getUsuario());

        usuarioPorFamiliaRepository.deleteByUsuarioPorFamiliaIdentityUsuarioDni(userDni);
        rolPorUsuarioRepository.deleteByRolPorUsuarioIdentityUsuarioDni(userDni);
        return usuarioPorFamiliaDtoConverter.convertToDto(usuario);
    }
}
