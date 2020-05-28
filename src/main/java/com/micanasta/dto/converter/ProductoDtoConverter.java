package com.micanasta.dto.converter;
import com.micanasta.dto.ProductoDto;
import com.micanasta.model.Producto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoDtoConverter {

    private final ModelMapper modelMapper;

    public ProductoDto convertToDto(Producto producto) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(producto.getId());
        productoDto.setCantidadUnit(producto.getCantidadUnit());
        productoDto.setDescripcion(producto.getDescripcion());
        productoDto.setCategoriaId(producto.getCategoria().getId());
        return productoDto;
    }

    public Producto convertToEntity(ProductoDto productoDto) {
        return modelMapper.map(productoDto, Producto.class);
    }
}
