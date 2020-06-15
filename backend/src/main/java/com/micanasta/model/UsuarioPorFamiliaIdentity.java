package com.micanasta.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class UsuarioPorFamiliaIdentity implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "familia_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Familia familia;

}
