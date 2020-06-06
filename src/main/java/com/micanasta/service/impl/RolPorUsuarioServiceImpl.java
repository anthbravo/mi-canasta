package com.micanasta.service.impl;

import com.micanasta.model.RolPorUsuario;
import com.micanasta.repository.RolPorUsuarioRepository;
import com.micanasta.service.RolPorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolPorUsuarioServiceImpl implements RolPorUsuarioService {
    @Autowired
    RolPorUsuarioRepository rolPorUsuarioRepository;

    public RolPorUsuario findByDni(String dni){
        return rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(dni);
    }

    public  RolPorUsuario editarRol(String dni){
        return rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(dni);
    }
}
