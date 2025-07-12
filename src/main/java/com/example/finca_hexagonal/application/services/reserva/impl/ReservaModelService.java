package com.example.finca_hexagonal.application.services.reserva.impl;

import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.ports.in.reserva.CreateReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.reserva.DeleteReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.reserva.GetReservaUseCase;
import com.example.finca_hexagonal.domain.ports.in.reserva.UpdateReservaUseCase;
import com.example.finca_hexagonal.infrastructure.exceptions.DateConflictException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaModelService implements CreateReservaUseCase, GetReservaUseCase, UpdateReservaUseCase, DeleteReservaUseCase {

    private final CreateReservaUseCase createReservaUseCase;
    private final GetReservaUseCase getReservaUseCase;
    private final UpdateReservaUseCase updateReservaUseCase;
    private final DeleteReservaUseCase deleteReservaUseCase;

    public ReservaModelService(CreateReservaUseCase createReservaUseCase, GetReservaUseCase getReservaUseCase, UpdateReservaUseCase updateReservaUseCase, DeleteReservaUseCase deleteReservaUseCase){
        this.createReservaUseCase = createReservaUseCase;
        this.getReservaUseCase = getReservaUseCase;
        this.updateReservaUseCase = updateReservaUseCase;
        this.deleteReservaUseCase = deleteReservaUseCase;
    }

    @Override
    public Reserva createReserva(Reserva reserva) {
        return createReservaUseCase.createReserva(reserva);
    }

    @Override
    public boolean deleteReserva(Long reservaId) {
        return deleteReservaUseCase.deleteReserva(reservaId);
    }

    @Override
    public List<Reserva> getAllReservas() {
        return getReservaUseCase.getAllReservas();
    }

    @Override
    public Optional<Reserva> getReservaById(Long reservaId) {
        return getReservaUseCase.getReservaById(reservaId);
    }

    @Override
    public Optional<Reserva> updateReserva(Long reservaId, Reserva updateReserva) {
        return updateReservaUseCase.updateReserva(reservaId, updateReserva);
    }

    @Override
    public List<Reserva> getReservasByFincaIdAndFecha(Long fincaId, LocalDate fecha) {
        return getReservaUseCase.getReservasByFincaIdAndFecha(fincaId, fecha);
    }

    public BigDecimal calcularTotalReserva(Reserva reserva) {
        if (reserva.getDesde() != null && reserva.getHasta() != null) {
            long horas = java.time.Duration.between(reserva.getDesde(), reserva.getHasta()).toHours();
            if (horas < 1) horas = 1;
            return reserva.getFinca().getTarifaHora().multiply(BigDecimal.valueOf(horas));
        } else {
            return BigDecimal.ZERO;
        }
    }

    public void validarFechaEspecial(FechaEspecial fecha, Reserva reserva) {
        LocalTime horaAperturaFinca = fecha.getHoraInicio();
        LocalTime horaCierreFinca = fecha.getHoraFin();

        LocalTime horaInicioReserva = reserva.getDesde();
        LocalTime horaFinReserva = reserva.getHasta();

        if ((horaInicioReserva.isAfter(horaAperturaFinca) || horaInicioReserva.equals(horaAperturaFinca)) &&
                (horaFinReserva.isBefore(horaCierreFinca) || horaFinReserva.equals(horaCierreFinca))){
            reserva.setTotal(reserva.getTotal().add(fecha.getRecargo()).subtract(fecha.getDescuento()));
            reserva.setDescuento(fecha.getDescuento());
            reserva.setRecargo(fecha.getRecargo());
            reserva.setDetalle(fecha.getMotivo());
        } else {
            throw new DateConflictException("La finca no esta disponible en ese horario");
        }
    }

    public void validarHorario(Reserva reserva, List<Horario> horariosDeFinca) {
        for (Horario hora : horariosDeFinca){
            LocalTime horaAperturaFinca = hora.getHoraInicio();
            LocalTime horaCierreFinca = hora.getHoraFin();

            LocalTime horaInicioReserva = reserva.getDesde();
            LocalTime horaFinReserva = reserva.getHasta();

            if ((horaInicioReserva.isAfter(horaAperturaFinca) || horaInicioReserva.equals(horaAperturaFinca)) &&
                    (horaFinReserva.isBefore(horaCierreFinca) || horaFinReserva.equals(horaCierreFinca))){
                return;
            }
        }
        throw new DateConflictException("La finca no esta disponible en ese horario");
    }

    public void validarReservasAnteriores(Reserva reserva, List<Reserva> reservasAnteriores) {
        for (Reserva reservaAnt : reservasAnteriores){
            LocalTime reservaAnteriorInicio = reservaAnt.getDesde();
            LocalTime reservaAnteriorFin = reservaAnt.getHasta();

            LocalTime reservaNuevaInicio = reserva.getDesde();
            LocalTime reservaNuevaFin = reserva.getHasta();
            boolean noHayConflicto = (reservaNuevaInicio.isAfter(reservaAnteriorFin) || reservaNuevaInicio.equals(reservaAnteriorFin)) ||
                    (reservaNuevaFin.isBefore(reservaAnteriorInicio) || reservaNuevaFin.equals(reservaAnteriorInicio));
            if (!noHayConflicto) {
                if (reservaAnt.getId() == reserva.getId()){
                    return;
                }
                throw new DateConflictException("La finca no esta disponible en ese horario");
            }
        }
    }
}
