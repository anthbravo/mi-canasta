package com.micanasta.dto.converter;

import com.micanasta.dto.CategoriaDto;
import com.micanasta.dto.ProductoDto;
import com.micanasta.model.Categoria;
import com.micanasta.model.Producto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriaDtoConverter {

    private final ModelMapper modelMapper;

    public CategoriaDto convertToDto(Categoria categoria) {
        return modelMapper.map(categoria, CategoriaDto.class);
    }

    public Categoria convertToEntity(CategoriaDto categoriaDto) {
        return modelMapper.map(categoriaDto, Categoria.class);
    }
}
