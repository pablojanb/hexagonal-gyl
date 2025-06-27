package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.permiso.PermisoRequestDTO;
import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.services.permiso.IPermisoService;
import com.example.finca_hexagonal.domain.models.Permiso;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class PermisoDTOMapper {

    private final IPermisoService permisoService;

    public PermisoDTOMapper(IPermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @Mapping(source = "nombre",target = "nombre")
    public abstract Permiso toModel(PermisoRequestDTO permisoRequestDTO);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    public abstract PermisoResponseDTO toDTO(Permiso permiso);

    public abstract List<PermisoResponseDTO> toListDto(List<Permiso> permisos);

    public abstract Permiso toModelFromResponse(PermisoResponseDTO permisoResponseDTO);

    @Named("mapIdsToPermisos")
    public Set<Permiso> mapIdsToPermisos(Set<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> toModelFromResponse(permisoService.findById(id)))
                .collect(Collectors.toSet());
    }
}
