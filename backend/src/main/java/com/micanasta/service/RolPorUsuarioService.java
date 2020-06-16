package com.micanasta.service;

import com.micanasta.dto.RolPorUsuarioDataDto;

import java.util.List;

public interface RolPorUsuarioService {
    List<RolPorUsuarioDataDto> findByDni(String dni);
}
