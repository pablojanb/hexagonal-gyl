package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.infrastructure.entities.FincaEntity;
import org.springframework.stereotype.Component;

@Component
public class FincaMappers {
    public FincaEntity fromDomainModel(Finca finca){
        return new FincaEntity(finca.getId(), finca.getNombre(), finca.getPropietario(), finca.getDetalle(), finca.getDireccion(), finca.getTarifa_hora());
    }

    public Finca toDomainModel(FincaEntity fincaEntity){
        return new Finca(fincaEntity.getId(), fincaEntity.getNombre(), fincaEntity.getPropietario(), fincaEntity.getDetalle(), fincaEntity.getDireccion(), fincaEntity.getTarifa_hora());
    }
}
