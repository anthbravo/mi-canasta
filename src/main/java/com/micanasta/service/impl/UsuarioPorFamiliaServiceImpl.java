package com.micanasta.service.impl;

import com.micanasta.dto.SolicitudUsuarioDto;
import com.micanasta.exception.SolicitudeTroubleException;
import com.micanasta.model.*;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.UsuarioPorFamiliaRepository;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.UsuarioPorFamiliaService;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioPorFamiliaServiceImpl implements UsuarioPorFamiliaService {
    @Autowired
    private UsuarioPorFamiliaRepository usuarioPorFamiliaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private FamiliaRepository familiaRepository;


    @Override
    public boolean AceptaSolicitudUsuario(SolicitudUsuarioDto solicitudUsuarioDto) throws SolicitudeTroubleException{

        Usuario usuario = usuarioRepository.findByDni(solicitudUsuarioDto.dni);
        Optional<Familia> optionalFamilia = familiaRepository.findById(solicitudUsuarioDto.familiaId);

        if(usuario != null && optionalFamilia.isPresent())
        {
            UsuarioPorFamiliaIdentity usuarioPorFamiliaIdentity = new UsuarioPorFamiliaIdentity();
            usuarioPorFamiliaIdentity.setUsuario(usuario);
            Familia familia = optionalFamilia.get();
            usuarioPorFamiliaIdentity.setFamilia(familia);
            UsuarioPorFamilia usuarioPorFamilia = new UsuarioPorFamilia();
            usuarioPorFamilia.setUsuarioPorFamiliaIdentity(usuarioPorFamiliaIdentity);
            usuarioPorFamiliaRepository.save(usuarioPorFamilia);
            return true;
        }
     throw new SolicitudeTroubleException();
    }

    @Override
    public Familia findFamiliaById(String dni) {
        Long familiaId = usuarioPorFamiliaRepository.findByDni(dni);
       if(familiaId!=null)
       {
           Optional<Familia> familia = familiaRepository.findById(familiaId);
            if(familia.isPresent())
                return familia.get();
       }
        return null;
    }
}
