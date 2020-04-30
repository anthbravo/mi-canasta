package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaDTO;
import com.micanasta.model.Familia;

import java.util.List;
import java.util.Optional;

public interface FamiliaService  {
    List<FamiliaDTO> getAll();
    Familia save(CrearFamiliaDTO familiaDTO) ;
    Optional<FamiliaDTO> findById(Long id) ;

    //List<FamiliaDTO> getAll(String nombreUnico) ;
}
