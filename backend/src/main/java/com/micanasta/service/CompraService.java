
package com.micanasta.service;

import com.micanasta.dto.CompraCreateDto;
import com.micanasta.dto.CompraDto;
import com.micanasta.dto.CompraUpdateDto;

import java.util.Date;
import java.util.List;

public interface CompraService {
    CompraCreateDto create(CompraCreateDto compraDto);
    List<CompraDto> getCompras(long idFamilia, String dni, Date fechaInicio, Date fechaFinal) throws Exception;
    CompraUpdateDto update(CompraUpdateDto historialDto) throws Exception;
}
