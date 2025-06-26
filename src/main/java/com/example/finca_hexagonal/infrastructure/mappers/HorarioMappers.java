package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.infrastructure.entities.HorarioEntity;
import org.springframework.stereotype.Component;

@Component
public class HorarioMappers {

    public HorarioEntity fromDomainModel(Horario horario){
        return new HorarioEntity();
    }

    public Horario toDomainModel(HorarioEntity horarioEntity){
        return new Horario();
    }
}
