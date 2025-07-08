package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.domain.models.Permiso;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PermisoDTOMapper {

    public abstract Permiso toModel(PermisoRequestDTO permisoRequestDTO);

    public abstract PermisoResponseDTO toDto(Permiso permiso);

    public abstract List<PermisoResponseDTO> toDtoList(List<Permiso> permisos);
}
