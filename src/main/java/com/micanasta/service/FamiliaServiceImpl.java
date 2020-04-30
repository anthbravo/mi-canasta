package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.converter.FamiliaDTOConverter;
import com.micanasta.model.*;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.RolPorUsuarioRepository;
import com.micanasta.repository.UsuarioPorFamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamiliaServiceImpl implements FamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private FamiliaDTOConverter familiaDTOConverter;

    @Autowired
    private UsuarioPorFamiliaRepository usuarioPorFamiliaRepository;

    @Autowired
    private RolPorUsuarioRepository rolPorUsuarioRepository;

    @Override
    @Transactional
    public Familia crearGrupoFamiliar(CrearFamiliaDTO familiaDTO) {
        Familia familia = familiaDTOConverter.convertToEntity(familiaDTO);
        familia.setAceptacionSolicitudes(true);
        familia.setCantidad(1);
        familia = familiaRepository.save(familia);

        Usuario usuario = new Usuario();
        RolPerfil rolPerfil = new RolPerfil();

        UsuarioPorFamilia usuarioPorFamilia = generarUsuarioPorFamilia(familiaDTO.getDni(),familia.getId());
        RolPorUsuario rolPorUsuario = asignarRolPorUsuario(usuario.getDni(), rolPerfil.getId());
        usuarioPorFamiliaRepository.save(usuarioPorFamilia);
        //rolPorUsuarioRepository.save(rolPorUsuario);

        return familia;

    }

    private UsuarioPorFamilia generarUsuarioPorFamilia(String dni, Long id ){
        UsuarioPorFamilia usuarioPorFamilia = new UsuarioPorFamilia();
        UsuarioPorFamiliaIdentity usuarioPorFamiliaIdentity = new UsuarioPorFamiliaIdentity();
        Familia familia = new Familia();
        familia.setId(id);
        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        usuarioPorFamiliaIdentity.setFamilia(familia);
        usuarioPorFamiliaIdentity.setUsuario(usuario);
        usuarioPorFamilia.setUsuarioPorFamiliaIdentity(usuarioPorFamiliaIdentity);

        return usuarioPorFamilia;
    }

    private RolPorUsuario asignarRolPorUsuario(String dni, Long id) {

        Perfil perfil = new Perfil();
        perfil.setId(id); // 1--> Administrador, 2--> Miembro
        perfil.setDescripcion("Administrador"); // olv

        RolPerfil rolPerfil = new RolPerfil();
        rolPerfil.setId(id); // 1--> UsuarioPorFamilia, 2--> UsuarioPorTienda
        rolPerfil.setDescripcion("Usuario por Familia");
        rolPerfil.setPerfil(perfil);

        Usuario usuario = new Usuario();
        usuario.setDni(dni);

        RolPorUsuarioIdentity rolPorUsuarioIdentity = new RolPorUsuarioIdentity();
        rolPorUsuarioIdentity.setUsuario(usuario);
        rolPorUsuarioIdentity.setRolPerfil(rolPerfil);

        RolPorUsuario rolPorUsuario = new RolPorUsuario();
        rolPorUsuario.setRolPorUsuarioIdentity(rolPorUsuarioIdentity);

        return rolPorUsuario;

    }
}
