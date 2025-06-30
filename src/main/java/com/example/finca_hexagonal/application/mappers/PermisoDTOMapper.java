package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.services.permiso.IPermisoService;
import com.example.finca_hexagonal.domain.models.Permiso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PermisoDTOMapper {


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "nombre",target = "nombre")
    })
    public abstract Permiso toModel(PermisoRequestDTO permisoRequestDTO);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    public abstract PermisoResponseDTO toDTO(Permiso permiso);

    public abstract List<PermisoResponseDTO> toListDto(List<Permiso> permisos);


}
