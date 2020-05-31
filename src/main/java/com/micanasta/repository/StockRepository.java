package com.micanasta.repository;

import com.micanasta.model.Stock;
import com.micanasta.model.StockIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockIdentity> {
    List<Stock> getByStockIdentityTiendaId(long id);
}
