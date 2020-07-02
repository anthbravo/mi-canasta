package com.micanasta.service.impl;

import com.micanasta.dto.CategoriaDto;
import com.micanasta.dto.LimiteDto;
import com.micanasta.dto.converter.CategoriaDtoConverter;
import com.micanasta.dto.converter.LimiteDtoConverter;
import com.micanasta.repository.CategoriaRepository;
import com.micanasta.repository.LimiteRepository;
import com.micanasta.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    LimiteRepository limiteRepository;

    @Autowired
    CategoriaDtoConverter categoriaDtoConverter;

    @Autowired
    LimiteDtoConverter limiteDtoConverter;

    @Override
    public CategoriaDto getById(long id) {

        return categoriaDtoConverter.convertToDto(categoriaRepository.getById(id));
    }

    @Override
    public LimiteDto getLimiteById(long id){
        return limiteDtoConverter.convertToDto(limiteRepository.getByCategoriaId(id));
    }

    @Override
    public List<CategoriaDto> getAll() {
        List<CategoriaDto> categoriasDto = categoriaRepository.findAll().stream().map((categoria) ->
                categoriaDtoConverter.convertToDto((categoria))).collect(Collectors.toList());
        return categoriasDto;
    }
}
