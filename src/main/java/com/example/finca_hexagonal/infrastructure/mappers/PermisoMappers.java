package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.infrastructure.entities.PermisoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PermisoMappers {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "nombre", target = "nombre")
    })
    public abstract PermisoEntity toEntity(Permiso permiso);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    public abstract Permiso toModel(PermisoEntity permisoEntity);

    public abstract List<PermisoEntity> toEntityList(List<Permiso> permisos);

    public abstract List<Permiso> toModelList(List<PermisoEntity> permisosEntity);
}
