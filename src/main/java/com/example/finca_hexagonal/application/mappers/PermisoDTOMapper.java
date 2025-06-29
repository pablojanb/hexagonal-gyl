package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.domain.models.Permiso;

import java.util.List;

public abstract class PermisoDTOMapper {

    public abstract Permiso toModel(PermisoRequestDTO permisoRequestDTO);

    public abstract PermisoResponseDTO toDTO(Permiso permiso);

    public abstract List<PermisoResponseDTO> toListDto(List<Permiso> permisos);
}
