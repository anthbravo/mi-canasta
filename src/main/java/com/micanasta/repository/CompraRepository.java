package com.micanasta.repository;

import com.micanasta.model.Compra;
import com.micanasta.model.CompraIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraIdentity> {

    List<Compra> getByCompraIdentityFamiliaNombreUnico(String Nombre);
    List<Compra> getByCompraIdentityFamiliaIdAndDni(long familiaId, String dni);

    Compra getByCompraIdentityFamiliaIdAndCompraIdentityProductoIdAndCompraIdentityTiendaId(long familiaId, long productoId, long tiendaId);

}

