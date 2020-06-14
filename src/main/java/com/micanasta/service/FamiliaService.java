package com.micanasta.service;

import com.micanasta.dto.*;
import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaBusquedaMiembrosDto;
import com.micanasta.dto.CompraDto;
import com.micanasta.dto.UsuarioPorFamiliaDto;
import com.micanasta.exception.*;
import com.micanasta.model.Familia;
import com.micanasta.model.Usuario;
import com.micanasta.model.UsuarioPorFamilia;

import java.util.Date;
import java.util.List;

public interface FamiliaService {

    Familia crearGrupoFamiliar(CrearFamiliaDTO familiaDTO) throws ExistingFamilyFoundException;

    Familia desactivarSolicitudes(Long idFamilia) throws FamilyNotFoundException;

    List<FamiliaBusquedaMiembrosDto> buscarMiembrosGrupoFamiliarPorNombreFamilia(String nombreFamilia);

    UsuarioPorFamiliaDto Remove(String userDni);

    FamiliaDataDto getById(Long id) throws FamilyNotFoundException;
    List<CompraDto> getCompra(String familiaNombre, Date fechaInicio, Date fechaFin);

    UsuarioPorFamilia editarRolUsuarioFamilia(String adminDni, String userDni) throws UserNotFoundException, UserNotAdminException;

}
