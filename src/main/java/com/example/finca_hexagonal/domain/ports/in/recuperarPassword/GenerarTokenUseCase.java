package com.example.finca_hexagonal.domain.ports.in.recuperarPassword;

import com.example.finca_hexagonal.domain.models.RecuperarPassword;

public interface GenerarTokenUseCase {
    RecuperarPassword generarToken(RecuperarPassword recuperarPassword);
}
