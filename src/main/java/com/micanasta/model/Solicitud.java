package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @EmbeddedId
    private SolicitudIdentity solicitudIdentity;

    public SolicitudIdentity getSolicitudIdentity() {
        return solicitudIdentity;
    }

    public void setSolicitudIdentity(SolicitudIdentity solicitudIdentity) {
        this.solicitudIdentity = solicitudIdentity;
    }
}
