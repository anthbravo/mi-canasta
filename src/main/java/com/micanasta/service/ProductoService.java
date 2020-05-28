package com.micanasta.service;

import com.micanasta.dto.ProductoDto;
import com.micanasta.model.Producto;

public interface ProductoService {

    ProductoDto getById(long id);
}
