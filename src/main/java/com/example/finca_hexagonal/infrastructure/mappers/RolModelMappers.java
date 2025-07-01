package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Rol;
import com.example.finca_hexagonal.infrastructure.entities.RolEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RolModelMappers {
    public abstract RolEntity fromDomainModel(Rol rol);

    public abstract Rol toDomainModel(RolEntity rolEntity);
}
