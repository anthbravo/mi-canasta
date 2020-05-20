package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.model.Familia;

import java.util.List;

public interface FamiliaService {

    Familia crearGrupoFamiliar(CrearFamiliaDTO familiaDTO);

    List<FamiliaBusquedaMiembrosDto> buscarMiembrosGrupoFamiliarPorNombreFamilia(String nombreFamilia) throws FamilyNotFoundException;

}
