package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaDTO;
import com.micanasta.model.Familia;
import com.micanasta.model.Heartbeat;

import java.util.List;
import java.util.Optional;


public interface FamiliaService {
    public List<Familia> getAll();

}

/*public interface FamiliaService  {
    Familia save(CrearFamiliaDTO familiaDTO) ;
    Optional<FamiliaDTO> findById(Long id) ;
    List<FamiliaDTO> findAll() ;
}*/
