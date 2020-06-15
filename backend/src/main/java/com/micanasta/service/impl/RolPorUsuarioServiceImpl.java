package com.micanasta.service.impl;

import com.micanasta.dto.RolPorUsuarioDataDto;
import com.micanasta.dto.converter.RolPorUsuarioDtoConverter;
import com.micanasta.model.RolPorUsuario;
import com.micanasta.repository.RolPorUsuarioRepository;
import com.micanasta.service.RolPorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolPorUsuarioServiceImpl implements RolPorUsuarioService {
    @Autowired
    RolPorUsuarioRepository rolPorUsuarioRepository;
    @Autowired
    RolPorUsuarioDtoConverter rolPorUsuarioDtoConverter;

    public List<RolPorUsuarioDataDto> findByDni(String dni){
        List<RolPorUsuarioDataDto> rolesPorUsuarioDto =
                rolPorUsuarioRepository.findAllById(dni).stream().map(rolPorUsuarioDtoConverter::convertToDataDto)
                .collect(Collectors.toList());
        return rolesPorUsuarioDto;
    }

}
