package com.example.finca_hexagonal.infrastructure.utils;

import com.example.finca_hexagonal.domain.models.enums.DiaDeSemana;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DiaSemanaConverter {
    public static DiaDeSemana convertirADiaDeSemana(LocalDate fecha) {
        return convertirADiaDeSemana(fecha.getDayOfWeek());
    }

    public static DiaDeSemana convertirADiaDeSemana(DayOfWeek dia) {
        switch (dia) {
            case MONDAY:
                return DiaDeSemana.LUNES;
            case TUESDAY:
                return DiaDeSemana.MARTES;
            case WEDNESDAY:
                return DiaDeSemana.MIERCOLES;
            case THURSDAY:
                return DiaDeSemana.JUEVES;
            case FRIDAY:
                return DiaDeSemana.VIERNES;
            case SATURDAY:
                return DiaDeSemana.SABADO;
            case SUNDAY:
                return DiaDeSemana.DOMINGO;
            default:
                throw new IllegalArgumentException("Día no válido");
        }
    }
}
