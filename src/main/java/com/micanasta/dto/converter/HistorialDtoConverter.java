package com.micanasta.dto.converter;

import com.micanasta.dto.HistorialDto;
import com.micanasta.model.Historial;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistorialDtoConverter {

    private final ModelMapper modelMapper;

    public HistorialDto convertToDto(Historial solicitud) {
        return modelMapper.map(solicitud, HistorialDto.class);
    }
    public Historial convertToEntity(HistorialDto solicitudDto) {
        return modelMapper.map(solicitudDto, Historial.class);

    }
}
