package com.micanasta.dto.converter;

import com.micanasta.dto.CrearSolicitudDto;
import com.micanasta.dto.SolicitudDto;
import com.micanasta.dto.TiendaDto;
import com.micanasta.model.Solicitud;
import com.micanasta.model.Tienda;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TiendaDtoConverter {

    private final ModelMapper modelMapper;

    public TiendaDto convertToDto(Tienda tienda) {
        return modelMapper.map(tienda, TiendaDto.class);

    }
}
