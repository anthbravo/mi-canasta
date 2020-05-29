package com.micanasta.repository;

import com.micanasta.model.Limite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiteRepository extends JpaRepository<Limite, Long>{
    Limite getByCategoriaId(long id);
}
