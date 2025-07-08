package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.authentication.AuthLoginRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthRegistroRequestDTO;
import com.example.finca_hexagonal.application.dto.authentication.AuthenticationResponseDTO;
import com.example.finca_hexagonal.domain.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AuthenticationDTOMapper {

    public abstract Usuario toModel(AuthLoginRequestDTO authDto);

    public abstract Usuario toModelFromRegistroDto(AuthRegistroRequestDTO authDto);

    public abstract AuthenticationResponseDTO toDto(Usuario usuario);
}
