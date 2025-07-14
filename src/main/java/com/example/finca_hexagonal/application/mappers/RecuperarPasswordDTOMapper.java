package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.recuperacionPassword.GenerarTokenRequestDTO;
import com.example.finca_hexagonal.domain.models.RecuperarPassword;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RecuperarPasswordDTOMapper {

    public abstract RecuperarPassword toModel(GenerarTokenRequestDTO generarTokenRequestDTO);
    public abstract RecuperarPassword toDto(RecuperarPassword recuperarPassword);
}
