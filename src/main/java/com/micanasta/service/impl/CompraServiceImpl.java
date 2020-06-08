package com.micanasta.service.impl;

import com.micanasta.dto.CompraCreateDto;
import com.micanasta.dto.converter.CompraDtoConverter;
import com.micanasta.model.Compra;
import com.micanasta.repository.CompraRepository;
import com.micanasta.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CompraDtoConverter compraDtoConverter;


    @Override
    public CompraCreateDto create(CompraCreateDto compraDto) {
        Compra compra = compraDtoConverter.convertToEntity(compraDto);
        compraRepository.save(compra);
        return compraDto;
    }
}
