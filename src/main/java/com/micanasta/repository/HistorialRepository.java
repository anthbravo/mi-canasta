package com.micanasta.repository;

import com.micanasta.model.Historial;
import com.micanasta.model.HistorialIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, HistorialIdentity> {

    List<Historial> getByHistorialIdentityFamiliaNombreUnico(String Nombre);

}

