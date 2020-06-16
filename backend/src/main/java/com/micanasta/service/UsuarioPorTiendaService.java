package com.micanasta.service;

import com.micanasta.model.Tienda;

public interface UsuarioPorTiendaService {
    Tienda findTiendaById(String dni);
}
