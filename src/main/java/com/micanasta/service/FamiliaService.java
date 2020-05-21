package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.exception.ExistingFamilyFoundException;
import com.micanasta.exception.FamilyNotFoundException;
import com.micanasta.model.Familia;

import java.util.List;

public interface FamiliaService {

    Familia crearGrupoFamiliar(CrearFamiliaDTO familiaDTO) throws ExistingFamilyFoundException;
    Familia desactivarSolicitudes(String nombreFamilia, String dni) throws FamilyNotFoundException;
    List<FamiliaBusquedaMiembrosDto> buscarMiembrosGrupoFamiliarPorNombreFamilia(String nombreFamilia);

}
