package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.infrastructure.entities.PermisoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PermisoModelMappers {

    public abstract PermisoEntity fromDomainModel(Permiso permiso);

    public abstract Permiso toDomainModel(PermisoEntity permisoEntity);
}
