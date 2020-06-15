package com.micanasta.service.impl;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.SolicitudBusquedaDto;
import com.micanasta.dto.SolicitudUsuarioDto;
import com.micanasta.dto.converter.SolicitudDtoConverter;
import com.micanasta.exception.FamilyNotAceptedSolicitudeException;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.model.Familia;
import com.micanasta.exception.SolicitudeNotFoundException;
import com.micanasta.model.Solicitud;
import com.micanasta.model.SolicitudIdentity;
import com.micanasta.model.Usuario;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.SolicitudRepository;
import com.micanasta.repository.UsuarioRepository;
import com.micanasta.service.SolicitudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public Solicitud create(CrearSolicitudDto solicitudDto)
            throws FamilyNotFoundException, FamilyNotAceptedSolicitudeException {

        Solicitud solicitud = null;

        if (familiaRepository.findByNombreUnico(solicitudDto.getNombreFamilia()) == null) {
            throw new FamilyNotFoundException();
        } else {
            if (aceptaSolicitudes(solicitudDto) == false) {
                throw new FamilyNotAceptedSolicitudeException();
            } else {
                solicitud = solicitudDtoConverter.convertToEntity(solicitudDto);
                SolicitudIdentity solicitudIdentity = new SolicitudIdentity();
                solicitudIdentity.setFamilia(familiaRepository.findByNombreUnico(solicitudDto.getNombreFamilia()));
                solicitudIdentity.setUsuario(usuarioRepository.findByDni(solicitudDto.getDni()));

                solicitud.setSolicitudIdentity(solicitudIdentity);
                solicitud = solicitudRepository.save(solicitud);
            }
        }
        return solicitud;
    }

    public boolean aceptaSolicitudes(CrearSolicitudDto solicitudDto) {
        if (familiaRepository.findByNombreUnico(solicitudDto.getNombreFamilia()).isAceptacionSolicitudes() == true)
            return true;
        else
            return false;

    }

    public SolicitudBusquedaDto solicitudPorDni(String dni) {

        SolicitudBusquedaDto solicitudBusquedaDto = new SolicitudBusquedaDto();

        Optional<Solicitud> solicitud = solicitudRepository.findBySolicitudIdentityUsuarioDni(dni);

        if (solicitud.isPresent()) {
            solicitudBusquedaDto.setDni(dni);
            solicitudBusquedaDto.setNombreFamilia(solicitud.get().getSolicitudIdentity().getFamilia().getNombreUnico());
        } else {
            solicitudBusquedaDto = null;
        }

        return solicitudBusquedaDto;
    }

    @Override
    public boolean borrarSolicitud(SolicitudUsuarioDto solicitudUsuarioDto) {
        Usuario usuario = usuarioRepository.findByDni(solicitudUsuarioDto.dni);
        Optional<Familia> optionalFamilia = familiaRepository.findById(solicitudUsuarioDto.familiaId);
        if (usuario != null && optionalFamilia.isPresent()) {
            SolicitudIdentity solicitudIdentity = new SolicitudIdentity();
            solicitudIdentity.setUsuario(usuario);
            Familia familia = optionalFamilia.get();
            solicitudIdentity.setFamilia(familia);
            Solicitud solicitud = new Solicitud();
            solicitud.setSolicitudIdentity(solicitudIdentity);
            solicitudRepository.delete(solicitud);
            return true;
        }
        return false;
    }


}
