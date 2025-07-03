package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.ImagenFinca;
import com.example.finca_hexagonal.infrastructure.entities.ImagenFincaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ImagenFincaModelMappers {
    public abstract ImagenFincaEntity fromDomainModel(ImagenFinca imagenFinca);

    public abstract ImagenFinca toDomainModel(ImagenFincaEntity imagenFincaEntity);
}
