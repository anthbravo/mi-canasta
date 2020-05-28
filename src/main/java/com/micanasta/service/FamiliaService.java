package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.dto.HistorialDto;
import com.micanasta.dto.UsuarioPorFamiliaDto;
import com.micanasta.exception.*;
import com.micanasta.model.Familia;

import java.util.Date;
import java.util.List;

public interface FamiliaService {

    Familia crearGrupoFamiliar(CrearFamiliaDTO familiaDTO) throws ExistingFamilyFoundException;

    Familia desactivarSolicitudes(String nombreFamilia, String dni) throws FamilyNotFoundException;

    List<FamiliaBusquedaMiembrosDto> buscarMiembrosGrupoFamiliarPorNombreFamilia(String nombreFamilia);

    UsuarioPorFamiliaDto Remove(String adminDni, String
            userDni) throws UserNotAdminException, UserToDeleteIsAdminException;

    UsuarioPorFamiliaDto RemoveMyself(String nombreFamilia, String
            userDni) throws UserOnlyAdminException;

    List<HistorialDto> getHistorial(String familiaNombre, Date fechaInicio, Date fechaFin);
}
