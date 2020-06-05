package com.micanasta.service.impl;

import com.micanasta.dto.*;
import com.micanasta.dto.converter.StockDtoConverter;
import com.micanasta.dto.converter.TiendaDtoConverter;
import com.micanasta.exception.UserAddedShopExceedLimitException;
import com.micanasta.exception.UserAddedShopIncorrectException;
import com.micanasta.exception.UserNotAdminException;
import com.micanasta.exception.UserNotFoundException;
import com.micanasta.model.*;
import com.micanasta.repository.*;
import com.micanasta.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiendaServiceimpl implements TiendaService {

    @Autowired
    TiendaRepository tiendaRepository;

    @Autowired
    TiendaDtoConverter tiendaDtoConverter;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    UsuarioPorTiendaRepository usuarioPorTiendaRepository;
    @Autowired
    StockDtoConverter stockDtoConverter;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolPorUsuarioRepository rolPorUsuarioRepository;

    @Autowired
    RolPerfilRepository rolPerfilRepository;



    @Override
    public TiendaDto getById(long id) {
        return tiendaDtoConverter.convertToDto(tiendaRepository.getById(id));
    }

    @Override
    public List<StockDto> getStocksById(long id){
        List<StockDto> stocksDto = new ArrayList<>();
        List<Stock> stocks = stockRepository.getByStockIdentityTiendaId(id);
        for(Stock stock : stocks){
            stocksDto.add(stockDtoConverter.convertToDto(stock));
        }
        return stocksDto;
    }

    @Transactional
    @Override
    public StockDto updateStock(long idTienda, long idProducto, StockUpdateDto stockUpdateDto) {
        Stock stock = stockRepository.getByStockIdentityTiendaIdAndStockIdentityProductoId(idTienda, idProducto);
        stock.setCantidad(stockUpdateDto.getCantidad());
        stockRepository.save(stock);
        return stockDtoConverter.convertToDto(stock);
    }
    public TiendaUsuarioDto postUsuarioInTienda(String dni, long tiendaId) throws UserAddedShopIncorrectException, UserAddedShopExceedLimitException
    {
        Usuario usuario = usuarioRepository.findByDni(dni);
        if (usuario != null){
            long cantidadUsuarios = usuarioPorTiendaRepository.countById(tiendaId);
            Optional<Tienda> tienda = tiendaRepository.findById(tiendaId);
            if (tienda.isPresent() && ( cantidadUsuarios+1<= tienda.get().getLimite())){
                UsuarioPorTienda usuarioPorTienda = new UsuarioPorTienda();
                UsuarioPorTiendaIdentity usuarioPorTiendaIdentity = new UsuarioPorTiendaIdentity();
                usuarioPorTiendaIdentity.setTienda(tienda.get());
                usuarioPorTiendaIdentity.setUsuario(usuario);
                usuarioPorTienda.setUsuarioPorTiendaIdentity(usuarioPorTiendaIdentity);
                usuarioPorTiendaRepository.save(usuarioPorTienda);
                TiendaUsuarioDto tiendaUsuarioDto = new TiendaUsuarioDto();
                tiendaUsuarioDto.setDni(usuario.getDni());
                tiendaUsuarioDto.setDescripcion(tienda.get().getDescripcion());
                tiendaUsuarioDto.setId((tienda.get().getId()));
                return tiendaUsuarioDto;
            }else throw new UserAddedShopExceedLimitException();
        }else throw new UserAddedShopIncorrectException();
    }
    public RolPorUsuario asignarRolPorUsuario(String dni, Long id) {

        RolPerfil rolPerfil = new RolPerfil();
        rolPerfil.setId(id); // 1--> UsuarioPorFamilia, 2--> UsuarioPorTienda

        Usuario usuario = new Usuario();
        usuario.setDni(dni);

        RolPorUsuarioIdentity rolPorUsuarioIdentity = new RolPorUsuarioIdentity();
        rolPorUsuarioIdentity.setUsuario(usuario);
        rolPorUsuarioIdentity.setRolPerfil(rolPerfil);

        RolPorUsuario rolPorUsuario = new RolPorUsuario();
        rolPorUsuario.setRolPorUsuarioIdentity(rolPorUsuarioIdentity);

        return rolPorUsuario;

    }
    @Transactional
    @Override
    public List <RolPorPerfilListaDto> switchRolPerfil(String userDni, String adminDni)throws UserNotFoundException, UserNotAdminException
    {
        List<RolPorPerfilListaDto> entry;

        if (usuarioPorTiendaRepository.findByDni(adminDni) == null) {
            throw new UserNotFoundException();
        }

        if (rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(adminDni).getRolPorUsuarioIdentity()
                .getRolPerfil().getId() != 1)
            throw new UserNotAdminException();

        if (usuarioPorTiendaRepository.findByDni(userDni) == null) {
            throw new UserNotFoundException();
        }

        else {
            if (rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(adminDni).getRolPorUsuarioIdentity().getRolPerfil().getId() == 1) {

                if (rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(userDni).getRolPorUsuarioIdentity().getRolPerfil().getId() == 1) {
                    RolPorUsuario rolPorUsuario;
                    rolPorUsuarioRepository.deleteByRolPorUsuarioIdentityUsuarioDni(userDni);
                    rolPorUsuario = asignarRolPorUsuario(userDni, (long) 4);
                    rolPorUsuarioRepository.save(rolPorUsuario);

                } else if (rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(userDni).getRolPorUsuarioIdentity().getRolPerfil().getId() == 2) {
                    RolPorUsuario rolPorUsuario;
                    rolPorUsuarioRepository.deleteByRolPorUsuarioIdentityUsuarioDni(userDni);
                    rolPorUsuario = asignarRolPorUsuario(userDni, (long) 3);
                    rolPorUsuarioRepository.save(rolPorUsuario);
                }
            }
        }

        /*Optional<List<RolPerfil>> listaRolPerfil = Optional.of(rolPerfilRepository.findAll());
        if(listaRolPerfil.isPresent()){
            entry =  listaRolPerfil.get().stream().map()



        }*/
       /*     List<FamiliaBusquedaMiembrosDto> familiaBusquedaMiembrosDtos;

        Optional<List<UsuarioPorFamilia>> miembrosGrupoFamiliarPorFamilia = usuarioPorFamiliaRepository
                .findByUsuarioPorFamiliaIdentityFamiliaNombreUnico(nombreFamilia);
        if (miembrosGrupoFamiliarPorFamilia.isPresent() && miembrosGrupoFamiliarPorFamilia.get().size() > 0) {

            familiaBusquedaMiembrosDtos = miembrosGrupoFamiliarPorFamilia.get().stream().map((miembro) -> {
                FamiliaBusquedaMiembrosDto familiaBusquedaMiembrosDto = new FamiliaBusquedaMiembrosDto();
                familiaBusquedaMiembrosDto.setDni(miembro.getUsuarioPorFamiliaIdentity().getUsuario().getDni());
                familiaBusquedaMiembrosDto.setNombre(miembro.getUsuarioPorFamiliaIdentity().getUsuario().getNombre());
                familiaBusquedaMiembrosDto
                        .setApellidoPaterno(miembro.getUsuarioPorFamiliaIdentity().getUsuario().getApellidoPaterno());
                familiaBusquedaMiembrosDto
                        .setApellidoMaterno(miembro.getUsuarioPorFamiliaIdentity().getUsuario().getApellidoMaterno());

                return familiaBusquedaMiembrosDto;
            }).collect(Collectors.toList());*/

        return null;
    }
    }

