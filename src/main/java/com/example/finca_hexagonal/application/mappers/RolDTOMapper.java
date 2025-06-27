package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.domain.models.Rol;

import java.util.List;

public abstract class RolDTOMapper {

    public abstract Rol toModel(RolRequestDTO rolRequestDTO);

    public abstract RolResponseDTO toDTO(Rol rol);

    public abstract List<RolResponseDTO> toListDto(List<Rol> rol);

}
