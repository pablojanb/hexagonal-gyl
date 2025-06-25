package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.infrastructure.entities.HorarioEntity;
import org.springframework.stereotype.Component;

@Component
public class HorarioMappers {

    public HorarioEntity fromDomainModel(Horario horario){
        return new HorarioEntity(horario.getId(), horario.getFinca(), horario.getHora_inicio(), horario.getHora_fin(), horario.getDia_Semana(), horario.getDescuento(), horario.getRecargo());
    }

    public Horario toDomainModel(HorarioEntity horarioEntity){
        return new Horario(horarioEntity.getId(), horarioEntity.getFinca(), horarioEntity.getHora_inicio(), horarioEntity.getHora_inicio(), horarioEntity.getDia_Semana(), horarioEntity.getDescuento(), horarioEntity.getRecargo());
    }
}
