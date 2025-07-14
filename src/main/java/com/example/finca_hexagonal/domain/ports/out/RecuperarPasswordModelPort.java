package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;

public interface RecuperarPasswordModelPort {

    RecuperarPassword save(RecuperarPassword recuperarPassword);

    RecuperarPassword findTokenByEmail(String email);

    RecuperarPassword update(Long id, RecuperarPassword recuperarPassword);
}
