package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Permiso;
import com.example.finca_hexagonal.infrastructure.entities.PermisoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public abstract class PermisoMappers {

    public abstract PermisoEntity toEntity(Permiso permiso);

    public abstract Permiso toModel(PermisoEntity permisoEntity);

    public abstract List<PermisoEntity> toEntityList(List<Permiso> permisos);

    public abstract List<Permiso> toModelList(List<PermisoEntity> permisosEntity);
}
