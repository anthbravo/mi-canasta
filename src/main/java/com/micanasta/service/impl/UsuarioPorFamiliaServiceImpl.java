package com.micanasta.service.impl;

import com.micanasta.dto.UsuarioDto;
import com.micanasta.dto.UsuarioPorFamiliaDto;
import com.micanasta.dto.converter.UsuarioPorFamiliaDtoConverter;
import com.micanasta.exception.UserNotAdminException;
import com.micanasta.exception.UserToDeleteIsAdminException;
import com.micanasta.model.Familia;
import com.micanasta.model.Usuario;
import com.micanasta.model.UsuarioPorFamilia;
import com.micanasta.model.UsuarioPorFamiliaIdentity;
import com.micanasta.repository.RolPorUsuarioRepository;
import com.micanasta.repository.UsuarioPorFamiliaRepository;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.UsuarioPorFamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public UsuarioPorFamiliaDto Remove(String adminDni, String userDni) throws UserNotAdminException, UserToDeleteIsAdminException {

        UsuarioPorFamiliaDto usuarioPorFamiliaDto=null;

        if(rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(adminDni).getRolPorUsuarioIdentity().getRolPerfil().getId()!=1)
            throw new UserNotAdminException();
        else{
            if(rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(userDni).getRolPorUsuarioIdentity().getRolPerfil().getId()==1)
                throw new UserToDeleteIsAdminException();
            else{
                UsuarioPorFamilia usuario=new UsuarioPorFamilia();
                Optional<UsuarioPorFamilia> usuarioPorFamilia =
                        usuarioPorFamiliaRepository.findByUsuarioPorFamiliaIdentityUsuarioDni(userDni);

                UsuarioPorFamiliaIdentity usuarioPorFamiliaIdentity=new UsuarioPorFamiliaIdentity();

                usuarioPorFamiliaIdentity.setFamilia(usuarioPorFamilia.get().getUsuarioPorFamiliaIdentity().getFamilia());
                usuarioPorFamiliaIdentity.setUsuario(usuarioPorFamilia.get().getUsuarioPorFamiliaIdentity().getUsuario());
                usuario.setUsuarioPorFamiliaIdentity(usuarioPorFamiliaIdentity);

                usuarioPorFamiliaRepository.deleteByUsuarioPorFamiliaIdentityUsuarioDni(userDni);
                rolPorUsuarioRepository.deleteByRolPorUsuarioIdentityUsuarioDni(userDni);

                usuarioPorFamiliaDto = usuarioPorFamiliaDtoConverter.convertToDto(usuario);
                usuarioPorFamiliaDto.setDni(userDni);
            }
        }
        return usuarioPorFamiliaDto;
    }
}
