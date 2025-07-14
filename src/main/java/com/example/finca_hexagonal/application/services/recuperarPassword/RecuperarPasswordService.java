package com.example.finca_hexagonal.application.services.recuperarPassword;

import com.example.finca_hexagonal.application.dto.recuperacionPassword.CambiarPasswordRequestDTO;
import com.example.finca_hexagonal.application.dto.recuperacionPassword.GenerarTokenRequestDTO;
import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import jakarta.mail.MessagingException;

public interface RecuperarPasswordService {
    RecuperarPassword crearToken(GenerarTokenRequestDTO generarTokenRequestDTO) throws MessagingException;

    RecuperarPassword geTokenByEmail(CambiarPasswordRequestDTO cambiarPasswordRequestDTO);
}
