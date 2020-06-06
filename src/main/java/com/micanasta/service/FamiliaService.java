package com.micanasta.service;

import com.micanasta.dto.*;
import com.micanasta.exception.*;
import com.micanasta.model.Familia;

import java.util.Date;
import java.util.List;

public interface FamiliaService {

    Familia crearGrupoFamiliar(CrearFamiliaDTO familiaDTO) throws ExistingFamilyFoundException;

    Familia desactivarSolicitudes(String nombreFamilia, String dni) throws FamilyNotFoundException;

    List<FamiliaBusquedaMiembrosDto> buscarMiembrosGrupoFamiliarPorNombreFamilia(String nombreFamilia);

    UsuarioPorFamiliaDto Remove(String userDni);

    List<HistorialDto> getHistorial(String familiaNombre, Date fechaInicio, Date fechaFin);

    FamiliaDataDto getById(Long id) throws FamilyNotFoundException;
}
