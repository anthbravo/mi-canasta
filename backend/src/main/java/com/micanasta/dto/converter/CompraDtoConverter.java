package com.micanasta.dto.converter;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.CompraCreateDto;
import com.micanasta.dto.CompraDto;
import com.micanasta.dto.CompraUpdateDto;
import com.micanasta.model.*;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.ProductoRepository;
import com.micanasta.repository.TiendaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompraDtoConverter {

    private final ModelMapper modelMapper;
    private final FamiliaRepository familiaRepository;
    private final ProductoRepository productoRepository;
    private final TiendaRepository tiendaRepository;

    public CompraDto convertToDto(Compra compra) {
        return modelMapper.map(compra, CompraDto.class);
    }

    public Compra convertToEntity(CompraCreateDto compraDto) {
        Compra compra = new Compra();
        compra.setCantidad(compraDto.getCantidad());
        compra.setConfirmacion(compraDto.isConfirmacion());
        compra.setDni(compraDto.getDni());
        compra.setFechaCompra(compraDto.getFechaCompra());

        Familia familia = familiaRepository.encontrarPorId(compraDto.getFamiliaId());
        Tienda tienda = tiendaRepository.getById(compraDto.getTiendaId());
        Producto producto = productoRepository.getById(compraDto.getProductoId());
        CompraIdentity compraIdentity = new CompraIdentity();

        compraIdentity.setFamilia(familia);
        compraIdentity.setProducto(producto);
        compraIdentity.setTienda(tienda);
        compra.setCompraIdentity(compraIdentity);

        return compra;
    }

}
