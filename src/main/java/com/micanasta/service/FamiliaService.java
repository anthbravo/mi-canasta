package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.model.Familia;
import com.micanasta.model.UsuarioPorFamilia;

import java.util.List;
import java.util.Optional;

public interface FamiliaService  {

    Familia crearGrupoFamiliar(CrearFamiliaDTO familiaDTO);

    List<FamiliaBusquedaMiembrosDto> buscarMiembrosGrupoFamiliarPorNombreFamilia(String nombreFamilia);

}
