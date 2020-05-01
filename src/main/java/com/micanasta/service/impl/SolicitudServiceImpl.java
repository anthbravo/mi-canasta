package com.micanasta.service.impl;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.converter.SolicitudDtoConverter;
import com.micanasta.model.*;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.SolicitudRepository;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private FamiliaRepository familiaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SolicitudDtoConverter solicitudDtoConverter;

    @Override
    @Transactional
    public Solicitud create(CrearSolicitudDto solicitudDto) {

        Solicitud solicitud = solicitudDtoConverter.convertToEntity(solicitudDto);
        SolicitudIdentity solicitudIdentity = new SolicitudIdentity();

        solicitudIdentity.setFamilia(asignarFamilia(solicitudDto.getNombreFamilia()));
        solicitudIdentity.setUsuario(asignarUsuario(solicitudDto.getDni()));

        solicitud.setSolicitudIdentity(solicitudIdentity);

        solicitud = solicitudRepository.save(solicitud);
        return solicitud;
    }

    private Familia asignarFamilia (String nombreFamilia){
        Familia familia1=new Familia();
        Familia familia2 =
                familiaRepository.findByNombreUnico(nombreFamilia);

        familia1.setId(familia2.getId());
        familia1.setNombreUnico(familia2.getNombreUnico());
        familia1.setAceptacionSolicitudes(true);

        return familia1;
    }

    private Usuario asignarUsuario (String dni){
        Usuario usuario1= new Usuario();
        Usuario usuario2 =
                usuarioRepository.findByDni(dni);
        usuario1.setApellidoMat(usuario2.getApellidoMat());
        usuario1.setApellidoPat(usuario2.getApellidoPat());
        usuario1.setContrasena(usuario2.getContrasena());
        usuario1.setCorreoElectronico(usuario2.getCorreoElectronico());
        usuario1.setDni(usuario2.getDni());
        usuario1.setNombre(usuario2.getNombre());

        return usuario1;
    }

}