package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.domain.models.Rol;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RolDTOMapper {

    public abstract Rol toModel(RolRequestDTO rolRequestDTO);

    public abstract RolResponseDTO toDto(Rol rol);

    public abstract List<RolResponseDTO> toDtoList(List<Rol> roles);
}
