package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.model.Familia;

public interface FamiliaService  {

    Familia crearGrupoFamiliar(CrearFamiliaDTO familiaDTO);

}
