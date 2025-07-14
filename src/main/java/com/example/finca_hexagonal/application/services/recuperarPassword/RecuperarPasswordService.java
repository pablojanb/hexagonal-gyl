package com.example.finca_hexagonal.application.services.recuperarPassword;

import com.example.finca_hexagonal.application.dto.recuperacionPassword.GenerarTokenRequestDTO;
import com.example.finca_hexagonal.domain.models.RecuperarPassword;

public interface RecuperarPasswordService {
    RecuperarPassword crearToken(GenerarTokenRequestDTO generarTokenRequestDTO);

    RecuperarPassword geTokenByEmail(String email);
}
