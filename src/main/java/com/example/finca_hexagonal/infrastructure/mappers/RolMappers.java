package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.infrastructure.entities.RolEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PermisoMappers.class)
public abstract class RolMappers {

    public abstract RolEntity toEntity(Rol rol);

    public abstract Rol toModel(RolEntity rolEntity);

    public abstract List<Rol> toModelList(List<RolEntity> rolEntityList);

    public abstract RolEntity toEntityList(List<Rol> rolList);
}
