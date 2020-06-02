package com.micanasta.service;

import com.micanasta.dto.HistorialCreateDto;
import com.micanasta.dto.HistorialDto;

public interface HistorialService {
    HistorialCreateDto create(HistorialCreateDto historialDto);
}
