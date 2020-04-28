package com.micanasta.service.impl;

import com.micanasta.dto.ImportarUsuarioReniecDTO;
import com.micanasta.model.Usuario;
import com.micanasta.service.ReniecService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Component
public class ReniecServiceImpl implements ReniecService {

    @Transactional(readOnly = true)
    @Override
    public Usuario findByDni(String dni) {
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "https://reniec-api.herokuapp.com/ciudadanos/{dni}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("dni", dni);
        return restTemplate.getForObject(uri,Usuario.class,params);
    }
}
