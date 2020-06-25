package com.micanasta.service.impl;

import com.micanasta.dto.SolicitudUsuarioDto;
import com.micanasta.exception.SolicitudeTroubleException;
import com.micanasta.model.*;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.SolicitudRepository;
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
    @Autowired
    private SolicitudRepository solicitudRepository;


    @Override
    public boolean AceptaSolicitudUsuario(SolicitudUsuarioDto solicitudUsuarioDto) throws SolicitudeTroubleException{

        Usuario usuario = usuarioRepository.findByDni(solicitudUsuarioDto.dni);
        Optional<Familia> optionalFamilia = familiaRepository.findById(solicitudUsuarioDto.familiaId);
        RolPorUsuario rolPorUsuario = new RolPorUsuario();
        if(usuario != null && optionalFamilia.isPresent())
        {
            Optional<Solicitud> solicitud = solicitudRepository.findBySolicitudIdentityUsuarioDni(solicitudUsuarioDto.dni);
            solicitudRepository.delete(solicitud.get());
            UsuarioPorFamiliaIdentity usuarioPorFamiliaIdentity = new UsuarioPorFamiliaIdentity();
            usuarioPorFamiliaIdentity.setUsuario(usuario);
            Familia familia = optionalFamilia.get();
            usuarioPorFamiliaIdentity.setFamilia(familia);
            UsuarioPorFamilia usuarioPorFamilia = new UsuarioPorFamilia();
            usuarioPorFamilia.setUsuarioPorFamiliaIdentity(usuarioPorFamiliaIdentity);
            usuarioPorFamiliaRepository.save(usuarioPorFamilia);
            rolPorUsuario = asignarRolPorUsuario(usuario.getDni(),(long)2);
            rolPorUsuarioRepository.save(rolPorUsuario);
            return true;
        }
        throw new SolicitudeTroubleException();
    }
    RolPorUsuario asignarRolPorUsuario(String dni, Long id) {

        RolPerfil rolPerfil = new RolPerfil();
        rolPerfil.setId(id);

        Usuario usuario = new Usuario();
        usuario.setDni(dni);

        RolPorUsuarioIdentity rolPorUsuarioIdentity = new RolPorUsuarioIdentity();
        rolPorUsuarioIdentity.setUsuario(usuario);
        rolPorUsuarioIdentity.setRolPerfil(rolPerfil);

        RolPorUsuario rolPorUsuario = new RolPorUsuario();
        rolPorUsuario.setRolPorUsuarioIdentity(rolPorUsuarioIdentity);

        return rolPorUsuario;

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
