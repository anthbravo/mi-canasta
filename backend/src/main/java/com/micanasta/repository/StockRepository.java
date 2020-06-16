package com.micanasta.repository;

import com.micanasta.model.Stock;
import com.micanasta.model.StockIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockIdentity> {
    List<Stock> getByStockIdentityTiendaId(long id);
    Stock getByStockIdentityTiendaIdAndStockIdentityProductoId(long tiendaId, long productoId);

    @Query(value = "select * from `stock` s where s.`producto_id` = ?1 and s.`cantidad`>=?2", nativeQuery = true)
    List<Stock> findByProductIdAndCantidad(long productId, float cantidad);
}
