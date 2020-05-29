package com.micanasta.service.impl;

import com.micanasta.model.Familia;
import com.micanasta.model.Tienda;
import com.micanasta.repository.TiendaRepository;
import com.micanasta.repository.UsuarioPorTiendaRepository;
import com.micanasta.service.UsuarioPorTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioPorTiendaServiceImpl implements UsuarioPorTiendaService {
    @Autowired
    UsuarioPorTiendaRepository usuarioPorTiendaRepository;
    @Autowired
    TiendaRepository tiendaRepository;

    @Override
    public Tienda findTiendaById(String dni) {
        Long tiendaId = usuarioPorTiendaRepository.findByDni(dni);
        if (tiendaId!=null)
        {
            Optional<Tienda> tienda = tiendaRepository.findById(tiendaId);
            if(tienda.isPresent())
                return tienda.get();
        }
        return null;

    }
}
