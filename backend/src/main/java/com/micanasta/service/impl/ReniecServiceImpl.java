package com.micanasta.service.impl;

import com.micanasta.dto.UsuarioReniecDto;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.ReniecService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ReniecServiceImpl implements ReniecService {


    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UsuarioReniecDto validateIdentity(String dni) {
        UsuarioReniecDto usuarioReniecDto;
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "https://reniec-api.herokuapp.com/ciudadanos/{dni}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("dni", dni);
        usuarioReniecDto = restTemplate.getForObject(uri, UsuarioReniecDto.class, params);
        if (usuarioReniecDto == null) {
            usuarioReniecDto = new UsuarioReniecDto();
            usuarioReniecDto.dni = "NotExist";
        }
        return usuarioReniecDto;


    }
}
