package com.micanasta.service;

import com.micanasta.dto.UsuarioReniecDto;

public interface ReniecService {

    UsuarioReniecDto validateIdentity(String dni);
}
