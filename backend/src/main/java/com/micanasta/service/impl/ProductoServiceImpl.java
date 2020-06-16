package com.micanasta.service.impl;

import com.micanasta.dto.ProductoDto;
import com.micanasta.dto.converter.FamiliaDTOConverter;
import com.micanasta.dto.converter.ProductoDtoConverter;
import com.micanasta.repository.ProductoRepository;
import com.micanasta.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoDtoConverter productoDtoConverter;

    @Override
    public ProductoDto getById(long id) {
        return productoDtoConverter.convertToDto(productoRepository.getById(id));
    }


}
