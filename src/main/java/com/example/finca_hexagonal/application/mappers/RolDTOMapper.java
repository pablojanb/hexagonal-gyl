package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.permiso.PermisoResponseDTO;
import com.example.finca_hexagonal.application.dto.rol.RolRequestDTO;
import com.example.finca_hexagonal.application.dto.rol.RolResponseDTO;
import com.example.finca_hexagonal.application.services.permiso.IPermisoService;
import com.example.finca_hexagonal.application.services.rol.IRolService;
import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.domain.models.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",uses = {PermisoDTOMapper.class})
public abstract class RolDTOMapper {



    @Autowired
    private IPermisoService permisoService;

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "nombre", target = "nombre"),
                @Mapping(source = "permisoIdSet", target = "permisoSet", qualifiedByName = "mapIdsToPermisos")
    })
    public abstract Rol toModel(RolRequestDTO rolRequestDTO);

    @Mappings(value = {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "permisoSet", target = "permisoSet")
    })
    public abstract RolResponseDTO toDTO(Rol rol);


    public abstract List<RolResponseDTO> toListDto(List<Rol> rol);


    public abstract Permiso toModelFromResponse(PermisoResponseDTO permisoResponseDTO);

    @Named("mapIdsToPermisos")
    public Set<Permiso> mapIdsToPermisos(Set<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> toModelFromResponse(permisoService.findById(id)))
                .collect(Collectors.toSet());
    }
}
