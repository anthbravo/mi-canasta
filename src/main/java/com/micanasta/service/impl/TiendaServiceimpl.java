package com.micanasta.service.impl;

import com.micanasta.dto.*;
import com.micanasta.dto.converter.StockDtoConverter;
import com.micanasta.dto.converter.TiendaDtoConverter;
import com.micanasta.exception.UserAddedShopExceedLimitException;
import com.micanasta.exception.UserAddedShopIncorrectException;
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
    private RolPorUsuarioRepository rolPorUsuarioRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

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
