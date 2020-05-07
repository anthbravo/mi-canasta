package com.micanasta.service.impl;

import com.micanasta.dto.converter.FamiliaDtoConverter;
import com.micanasta.dto.converter.SolicitudDtoConverter;
import com.micanasta.model.Familia;
import com.micanasta.model.UsuarioPorFamilia;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.SolicitudRepository;
import com.micanasta.repository.UsuarioPorFamiliaRepository;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamiliaServiceImpl implements FamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;
    @Autowired
    private UsuarioPorFamiliaRepository usuarioPorFamiliaRepositoryRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private FamiliaDtoConverter familiaDtoConverter;

    @Override
    public Familia getByNombre(String nombre) {

        return familiaRepository.findByNombreUnico(nombre);
    }

    @Override
    public Optional<UsuarioPorFamilia> getUsuariosPorFamilia(String nombre) {
        Familia familia=familiaRepository.findByNombreUnico(nombre);
        return usuarioPorFamiliaRepositoryRepository.findByUsuarioPorFamiliaIdIdentity_Familia(familia.getId());
    }

}
