package com.micanasta.service.impl;

import com.micanasta.dto.*;
import com.micanasta.dto.converter.RolPorPerfilDtoConverter;
import com.micanasta.dto.converter.StockDtoConverter;
import com.micanasta.dto.converter.TiendaDtoConverter;
import com.micanasta.exception.*;
import com.micanasta.model.*;
import com.micanasta.repository.*;
import com.micanasta.service.TiendaService;
import com.micanasta.service.UsuarioService;
import lombok.var;
import org.modelmapper.ModelMapper;
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

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public TiendaDto getById(long id) {

        return tiendaDtoConverter.convertToDto(tiendaRepository.getById(id));
    }

    @Override
    public List<StockDto> getStocksById(long id) {
        List<StockDto> stocksDto = new ArrayList<>();
        List<Stock> stocks = stockRepository.getByStockIdentityTiendaId(id);
        for (Stock stock : stocks) {
            stocksDto.add(stockDtoConverter.convertToDto(stock));
        }
        return stocksDto;
    }

    @Override
    public TiendaLimiteDto getLimiteTienda(long id) {
        TiendaDto tienda = tiendaDtoConverter.convertToDto(tiendaRepository.getById(id));
        if (tienda != null) {
            TiendaLimiteDto limiteDto = new TiendaLimiteDto();
            limiteDto.setLimite(tienda.getLimite());
            return limiteDto;
        } else
            return null;
    }

    @Transactional
    @Override
    public StockDto updateStock(long idTienda, long idProducto, StockUpdateDto stockUpdateDto) {
        Stock stock = stockRepository.getByStockIdentityTiendaIdAndStockIdentityProductoId(idTienda, idProducto);
        stock.setCantidad(stockUpdateDto.getCantidad());
        stockRepository.save(stock);
        return stockDtoConverter.convertToDto(stock);
    }

    public TiendaUsuarioDto postUsuarioInTienda(long idTienda, String dni) throws UserAddedShopIncorrectException, UserAddedShopExceedLimitException {
        Usuario usuario = usuarioRepository.findByDni(dni);
        if (usuario != null) {
            long cantidadUsuarios = usuarioPorTiendaRepository.countById(idTienda);
            Optional<Tienda> tienda = tiendaRepository.findById(idTienda);
            if (tienda.isPresent() && (cantidadUsuarios + 1 <= tienda.get().getLimite())) {
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
                RolPorUsuario rolPorUsuario = new RolPorUsuario();
                rolPorUsuario = asignarRolPorUsuario(usuario.getDni(), (long) 4);
                rolPorUsuarioRepository.save(rolPorUsuario);
                return tiendaUsuarioDto;
            } else throw new UserAddedShopExceedLimitException();
        } else throw new UserAddedShopIncorrectException();
    }


    public RolPorUsuario asignarRolPorUsuario(String dni, Long id) {

        RolPerfil rolPerfil = new RolPerfil();
        rolPerfil.setId(id);

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
    public UsuarioPorTienda cambiarRolUsuario(String dni) throws UserNotFoundException {
        if (usuarioPorTiendaRepository.findByDni(dni) == null) {
            throw new UserNotFoundException();
        } else {
            if (rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(dni).getRolPorUsuarioIdentity().getRolPerfil().getId() == 3) {
                RolPorUsuario rolPorUsuario;
                rolPorUsuarioRepository.deleteByRolPorUsuarioIdentityUsuarioDni(dni);
                rolPorUsuario = asignarRolPorUsuario(dni, (long) 4);
                rolPorUsuarioRepository.save(rolPorUsuario);

            } else if (rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(dni).getRolPorUsuarioIdentity().getRolPerfil().getId() == 4) {
                RolPorUsuario rolPorUsuario;
                rolPorUsuarioRepository.deleteByRolPorUsuarioIdentityUsuarioDni(dni);
                rolPorUsuario = asignarRolPorUsuario(dni, (long) 3);
                rolPorUsuarioRepository.save(rolPorUsuario);
            }
        }
        return null;

    }

    @Transactional
    @Override
    public TiendaInfoDto getTiendaInfo(long idTienda) {

        Tienda tienda = tiendaRepository.getById(idTienda);

        if (tienda != null) {
            List<Stock> stocks = stockRepository.getByStockIdentityTiendaId(idTienda);
            List<StockInfoDto> stockNombre = new ArrayList<>();
            TiendaInfoDto result = new TiendaInfoDto();


            for (Stock stock : stocks) {

                StockInfoDto stockInfoDto = new StockInfoDto();
                stockInfoDto.setNombre(stock.getStockIdentity().getProducto().getDescripcion());
                stockInfoDto.setCantidad(stock.getCantidad());
                stockNombre.add(stockInfoDto);
            }
            result.setDescripcion(tienda.getDescripcion());
            result.setDireccion(tienda.getDireccion());
            result.setHorario(tienda.getHorario());
            result.setStock(stockNombre)
            ;


            return result;
        }
        else return null;
    }

    @Transactional
    @Override
    public TiendaDto updateTienda(long idTienda, String dni, TiendaUpdateDto tiendaUpdateDto) throws ActualPasswordNotMatchException{
        Usuario usuario = usuarioRepository.encontrarPorDni(dni);
        Tienda tienda = tiendaRepository.encontrarPorId(idTienda);

        if(!usuario.getContrasena().equals(tiendaUpdateDto.contrasena)){
            throw new ActualPasswordNotMatchException();
        }
        else {
            if(tiendaUpdateDto.getDescripcion()!=null)
                tienda.setDescripcion(tiendaUpdateDto.descripcion);
            if(tiendaUpdateDto.getDireccion()!=null)
                tienda.setDireccion(tiendaUpdateDto.getDireccion());
            if(tiendaUpdateDto.getHorario()!=null)
                tienda.setHorario(tiendaUpdateDto.getHorario());
            if(tiendaUpdateDto.getLatitud()!=null)
                tienda.setLatitud(tiendaUpdateDto.getLatitud());
            if(tiendaUpdateDto.getLongitud()!=null)
                tienda.setLongitud(tiendaUpdateDto.getLongitud());
            tiendaRepository.save(tienda);
        }
        return tiendaDtoConverter.convertToDto(tienda);
    }

    public List<TiendaDto>getAllTiendas(){

        List<TiendaDto> tiendasDto = new ArrayList<>();
        List<Tienda> tiendas= tiendaRepository.findAll();
        if(tiendas!=null) {
            for (Tienda tienda : tiendas) {
                tiendasDto.add(tiendaDtoConverter.convertToDto(tienda));
            }
            return tiendasDto;
        }
        else return null;
    }

    @Override
    public List<TiendaBusquedaMiembrosDto> buscarMiembrosGrupoDistribuidoraPorTiendaId(long id) {
        List<TiendaBusquedaMiembrosDto> tiendaBusquedaMiembrosDtos;

        Optional<List<UsuarioPorTienda>> miembrosGrupoDistruibuidoraPorTienda = usuarioPorTiendaRepository
                .findByUsuarioPorTiendaIdentityTiendaId(id);

        if (miembrosGrupoDistruibuidoraPorTienda.isPresent() && miembrosGrupoDistruibuidoraPorTienda.get().size() > 0) {

            tiendaBusquedaMiembrosDtos = miembrosGrupoDistruibuidoraPorTienda.get().stream().map((miembro) -> {
                TiendaBusquedaMiembrosDto tiendaBusquedaMiembrosDto = new TiendaBusquedaMiembrosDto();

                tiendaBusquedaMiembrosDto.setDni(miembro.getUsuarioPorTiendaIdentity().getUsuario().getDni());
                tiendaBusquedaMiembrosDto.setNombre(miembro.getUsuarioPorTiendaIdentity().getUsuario().getNombre());
                tiendaBusquedaMiembrosDto.setApellidoPaterno(miembro.getUsuarioPorTiendaIdentity().getUsuario().getApellidoPaterno());
                tiendaBusquedaMiembrosDto.setApellidoMaterno(miembro.getUsuarioPorTiendaIdentity().getUsuario().getApellidoMaterno());
                //rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(miembro.getUsuarioPorTiendaIdentity().getUsuario().getDni());

                tiendaBusquedaMiembrosDto.setRolId(rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(miembro.getUsuarioPorTiendaIdentity().getUsuario()
                        .getDni()).getRolPorUsuarioIdentity().getRolPerfil().getId());
                tiendaBusquedaMiembrosDto.setDescripción(rolPorUsuarioRepository.findByRolPorUsuarioIdentityUsuarioDni(miembro.getUsuarioPorTiendaIdentity().getUsuario()
                        .getDni()).getRolPorUsuarioIdentity().getRolPerfil().getDescripcion());

                return tiendaBusquedaMiembrosDto;

            }).collect(Collectors.toList());
        } else {
            tiendaBusquedaMiembrosDtos = null;
        }
        return tiendaBusquedaMiembrosDtos;
    }

}


