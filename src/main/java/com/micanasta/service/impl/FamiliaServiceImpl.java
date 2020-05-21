package com.micanasta.service.impl;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.dto.converter.FamiliaDTOConverter;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.model.*;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.RolPorUsuarioRepository;
import com.micanasta.repository.UsuarioPorFamiliaRepository;
import com.micanasta.service.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

        UsuarioPorFamilia usuarioPorFamilia = generarUsuarioPorFamilia(familiaDTO.getDni(), familia.getId());
        RolPorUsuario rolPorUsuario = asignarRolPorUsuario(familiaDTO.getDni(), (long) 1); // Asignación directa
        usuarioPorFamiliaRepository.save(usuarioPorFamilia);
        rolPorUsuarioRepository.save(rolPorUsuario);
        return familia;
    }

    @Override
    public List<FamiliaBusquedaMiembrosDto> buscarMiembrosGrupoFamiliarPorNombreFamilia(String nombreFamilia) throws FamilyNotFoundException {

        List<FamiliaBusquedaMiembrosDto> familiaBusquedaMiembrosDtos = null;

        Optional<List<UsuarioPorFamilia>> miembrosGrupoFamiliarPorFamilia = usuarioPorFamiliaRepository.findByUsuarioPorFamiliaIdentityFamiliaNombreUnico(nombreFamilia);

        if (!miembrosGrupoFamiliarPorFamilia.isPresent()) {
            throw new FamilyNotFoundException();
        } else {
            familiaBusquedaMiembrosDtos = miembrosGrupoFamiliarPorFamilia.get().stream()
                    .map((miembro) -> {
                        FamiliaBusquedaMiembrosDto familiaBusquedaMiembrosDto = new FamiliaBusquedaMiembrosDto();
                        familiaBusquedaMiembrosDto.setDni(miembro.getUsuarioPorFamiliaIdentity().getUsuario().getDni());
                        familiaBusquedaMiembrosDto.setNombre(miembro.getUsuarioPorFamiliaIdentity().getUsuario().getNombre());
                        familiaBusquedaMiembrosDto.setApellidoPaterno(miembro.getUsuarioPorFamiliaIdentity().getUsuario().getApellidoPaterno());
                        familiaBusquedaMiembrosDto.setApellidoMaterno(miembro.getUsuarioPorFamiliaIdentity().getUsuario().getApellidoMaterno());

                        return familiaBusquedaMiembrosDto;
                    })
                    .collect(Collectors.toList());
        }

        return familiaBusquedaMiembrosDtos;
    }

    private UsuarioPorFamilia generarUsuarioPorFamilia(String dni, Long id) {
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

        RolPerfil rolPerfil = new RolPerfil();
        rolPerfil.setId(id); // 1--> UsuarioPorFamilia, 2--> UsuarioPorTienda

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

