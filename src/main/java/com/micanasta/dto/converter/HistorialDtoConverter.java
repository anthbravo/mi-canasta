package com.micanasta.dto.converter;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.HistorialCreateDto;
import com.micanasta.dto.HistorialDto;
import com.micanasta.dto.HistorialUpdateDto;
import com.micanasta.model.*;
import com.micanasta.repository.FamiliaRepository;
import com.micanasta.repository.ProductoRepository;
import com.micanasta.repository.TiendaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistorialDtoConverter {

    private final ModelMapper modelMapper;
    private final FamiliaRepository familiaRepository;
    private final ProductoRepository productoRepository;
    private final TiendaRepository tiendaRepository;

    public HistorialDto convertToDto(Historial historial) {
        return modelMapper.map(historial, HistorialDto.class);
    }

    public Historial convertToEntity(HistorialCreateDto historialDto) {
        Historial historial = new Historial();
        historial.setCantidad(historialDto.getCantidad());
        historial.setConfirmacion(historialDto.isConfirmacion());
        historial.setDni(historialDto.getDni());
        historial.setFechaCompra(historialDto.getFechaCompra());

        Familia familia = familiaRepository.encontrarPorId(historialDto.getFamiliaId());
        Tienda tienda = tiendaRepository.getById(historialDto.getTiendaId());
        Producto producto = productoRepository.getById(historialDto.getProductoId());
        HistorialIdentity historialIdentity = new HistorialIdentity();

        historialIdentity.setFamilia(familia);
        historialIdentity.setProducto(producto);
        historialIdentity.setTienda(tienda);
        historial.setHistorialIdentity(historialIdentity);

        return historial;
    }

}
