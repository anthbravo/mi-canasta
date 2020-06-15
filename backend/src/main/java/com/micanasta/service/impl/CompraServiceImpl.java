package com.micanasta.service.impl;

import com.micanasta.dto.CompraCreateDto;
import com.micanasta.dto.CompraDto;
import com.micanasta.dto.CompraUpdateDto;
import com.micanasta.dto.converter.CompraDtoConverter;
import com.micanasta.model.Compra;
import com.micanasta.repository.CompraRepository;
import com.micanasta.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CompraDto> getCompras(long idFamilia, String dni, Date fechaInicio, Date fechaFinal) throws Exception {
        List<CompraDto> comprasDto;
        List<Compra> comprasAux = new ArrayList<>();

        for (Compra compra : compraRepository.getByCompraIdentityFamiliaIdAndDni(idFamilia, dni)) {
            if (compra.getFechaCompra().after(fechaInicio) && compra.getFechaCompra().before(fechaFinal)) {
                comprasAux.add(compra);
            }
        }

        comprasDto = comprasAux.stream().map(x -> {
            CompraDto compraDto = new CompraDto();
            compraDto.setDni(x.getDni());
            compraDto.setCantidad(x.getCantidad());
            compraDto.setFechaCompra(x.getFechaCompra());
            compraDto.setFamiliaId(x.getCompraIdentity().getFamilia().getId());
            compraDto.setProductoId(x.getCompraIdentity().getProducto().getId());
            compraDto.setTiendaId(x.getCompraIdentity().getTienda().getId());
            compraDto.setConfirmacion(x.isConfirmacion());
            return compraDto;
        }).collect(Collectors.toList());
        if(comprasDto.size()==0) throw new Exception();
        return comprasDto;
    }

    @Override
    public CompraUpdateDto update(CompraUpdateDto compraDto) throws Exception {
        Compra compra =
                compraRepository.getByCompraIdentityFamiliaIdAndCompraIdentityProductoIdAndCompraIdentityTiendaId(compraDto.getFamiliaId(), compraDto.getProductoId(),
                        compraDto.getTiendaId());
        if(compra!=null){
           compra.setDni(compraDto.getDni());
           compra.setFechaCompra(compraDto.getFechaCompra());
           compra.setConfirmacion(compraDto.isConfirmacion());
           compra.setCantidad(compraDto.getCantidad());
           compraRepository.save(compra);
        }
        else throw new Exception();
        return compraDto;
    }
}

