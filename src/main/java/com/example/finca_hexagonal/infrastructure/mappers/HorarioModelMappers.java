package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.infrastructure.entities.HorarioEntity;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public abstract class HorarioModelMappers {

    public abstract HorarioEntity fromDomainModel(Horario horario);

    public abstract Horario toDomainModel(HorarioEntity horarioEntity);
}
