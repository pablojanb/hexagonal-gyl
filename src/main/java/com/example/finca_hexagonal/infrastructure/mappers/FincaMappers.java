package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.infrastructure.entities.FincaEntity;
import org.springframework.stereotype.Component;

@Component
public class FincaMappers {
    public FincaEntity fromDomainModel(Finca finca){
        return new FincaEntity();
    }

    public Finca toDomainModel(FincaEntity fincaEntity){
        return new Finca();
    }
}
