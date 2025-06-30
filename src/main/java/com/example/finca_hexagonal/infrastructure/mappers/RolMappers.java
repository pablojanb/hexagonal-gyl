package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.infrastructure.entities.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = PermisoMappers.class)
public abstract class RolMappers {


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "permisoSet", target = "permisoEntitySet")
    })
    public abstract RolEntity toEntity(Rol rol);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "permisoEntitySet", target = "permisoSet")
    })
    public abstract Rol toModel(RolEntity rolEntity);

    public abstract List<Rol> toModelList(List<RolEntity> rolEntityList);

    public abstract RolEntity toEntityList(List<Rol> rolList);
}
