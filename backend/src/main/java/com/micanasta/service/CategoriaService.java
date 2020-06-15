package com.micanasta.service;


import com.micanasta.dto.CategoriaDto;
import com.micanasta.dto.LimiteDto;

public interface CategoriaService {
    CategoriaDto getById(long id);
    LimiteDto getLimiteById(long id);
}
