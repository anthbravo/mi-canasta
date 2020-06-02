package com.micanasta.service.impl;

import com.micanasta.dto.HistorialCreateDto;
import com.micanasta.dto.converter.HistorialDtoConverter;
import com.micanasta.model.Historial;
import com.micanasta.repository.HistorialRepository;
import com.micanasta.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private HistorialDtoConverter historialDtoConverter;


    @Override
    public HistorialCreateDto create(HistorialCreateDto historialDto) {
        Historial historial = historialDtoConverter.convertToEntity(historialDto);
        historialRepository.save(historial);
        return historialDto;
    }
}
