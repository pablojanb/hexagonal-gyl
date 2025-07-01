package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.infrastructure.entities.ReservaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ReservaModelMappers {

    public abstract ReservaEntity fromDomainModel(Reserva reserva);

    public abstract Reserva toDomainModel(ReservaEntity reservaEntity);
}
