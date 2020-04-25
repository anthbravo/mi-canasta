package com.micanasta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rolesPorUsuario")
public class RolPorUsuario {

   @EmbeddedId
    private RolPorUsuarioIdentity rolPorUsuarioIdentity;
}
