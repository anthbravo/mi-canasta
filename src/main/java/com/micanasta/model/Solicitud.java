package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {
    @OneToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = )
    private Usuario dni;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="familia_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Familia idFamilia;


}
