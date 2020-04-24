package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @OneToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "usuario_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="familia_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Familia familia;


}
