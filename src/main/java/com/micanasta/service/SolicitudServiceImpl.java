package com.micanasta.service;

import com.micanasta.model.Solicitud;
import com.micanasta.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    SolicitudRepository solicitudRepository;

    @Override

     public List<Solicitud> getAll(){
        return solicitudRepository.findAll();
    }
}
