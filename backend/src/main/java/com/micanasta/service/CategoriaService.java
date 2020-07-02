package com.micanasta.service;


import com.micanasta.dto.CategoriaDto;
import com.micanasta.dto.LimiteDto;

import java.util.List;

public interface CategoriaService {
    CategoriaDto getById(long id);
    LimiteDto getLimiteById(long id);
    List<CategoriaDto> getAll();
}
