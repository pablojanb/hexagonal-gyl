package com.example.finca_hexagonal.application.services.reserva.impl;

import com.example.finca_hexagonal.application.dto.reservas.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.application.mappers.ReservaDTOMapper;
import com.example.finca_hexagonal.application.services.fechaEspecial.impl.FechaEspecialModelService;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.application.services.horario.impl.HorarioModelService;
import com.example.finca_hexagonal.application.services.reserva.ReservaService;
import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.Horario;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.infrastructure.exceptions.DateConflictException;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaModelService reservaModelService;
    private final ReservaDTOMapper reservaDTOMapper;
    private final FincaModelService fincaModelService;
    private final FechaEspecialModelService fechaEspecialModelService;
    private final HorarioModelService horarioModelService;

    public ReservaServiceImpl(ReservaModelService reservaModelService, ReservaDTOMapper reservaDTOMapper, FincaModelService fincaModelService, FechaEspecialModelService fechaEspecialModelService, HorarioModelService horarioModelService) {
        this.reservaModelService = reservaModelService;
        this.reservaDTOMapper = reservaDTOMapper;
        this.fincaModelService = fincaModelService;
        this.fechaEspecialModelService = fechaEspecialModelService;
        this.horarioModelService = horarioModelService;
    }

    @Override
    public ReservaResponseDTO create(ReservaRequestDTO reservaDto) {
        Finca finca = fincaModelService.getFincaById(reservaDto.getIdFinca())
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + reservaDto.getIdFinca()));
        Reserva reserva = reservaDTOMapper.toModel(reservaDto);
        BigDecimal montoBase = reservaModelService.calcularTotalReserva(reserva);
        reserva.setTotal(montoBase);

        if (reserva.getDesde().isAfter(reserva.getHasta())){
            throw new DateConflictException("La hora de inicio debe ser anterior a la hora de finalización");
        }
        Optional<FechaEspecial> fechaEspDeFinca = fechaEspecialModelService.getFechaEspecialByFincaIdAndFecha(finca.getId(), reserva.getFecha());
        if (fechaEspDeFinca.isPresent()){
            FechaEspecial fecha = fechaEspDeFinca.get();
            reservaModelService.validarFechaEspecial(fecha, reserva);
        } else {
            List<Horario> horariosDeFinca = horarioModelService.getAllHorariosByFincaIdAndDayOfWeek(finca.getId(), reserva.getDiaSemana());
            if (horariosDeFinca.isEmpty()) {
                throw new DateConflictException("La finca no esta disponible en ese horario");
            }
            reservaModelService.validarHorario(reserva, horariosDeFinca);
        }
        List<Reserva> reservasAnteriores = reservaModelService.getReservasByFincaIdAndFecha(reserva.getFinca().getId(), reserva.getFecha());
        reservaModelService.validarReservasAnteriores(reserva, reservasAnteriores);
        Reserva newReserva = reservaModelService.createReserva(reserva);
        return reservaDTOMapper.toDto(newReserva);
    }

    @Override
    public List<ReservaResponseDTO> getAll() {
        List<Reserva> reservas = reservaModelService.getAllReservas();
        return reservaDTOMapper.toDtoList(reservas);
    }

    @Override
    public Optional<ReservaResponseDTO> getById(Long reservaId) {
        Reserva reserva = reservaModelService.getReservaById(reservaId)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada: " + reservaId));
        return Optional.of(reservaDTOMapper.toDto(reserva));
    }

    @Override
    public Optional<ReservaResponseDTO> updateById(Long reservaId, ReservaRequestDTO updateReservaDto) {
        Reserva reservaToUpdate = reservaModelService.getReservaById(reservaId)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada: " + reservaId));
        Reserva newData = reservaDTOMapper.toModel(updateReservaDto);
        reservaToUpdate.setUsuario(newData.getUsuario());
        reservaToUpdate.setFinca(newData.getFinca());
        reservaToUpdate.setFecha(newData.getFecha());
        reservaToUpdate.setDesde(newData.getDesde());
        reservaToUpdate.setHasta(newData.getHasta());
        reservaToUpdate.setDiaSemana(newData.getDiaSemana());

        BigDecimal montoBase = reservaModelService.calcularTotalReserva(reservaToUpdate);
        reservaToUpdate.setTotal(montoBase);

        if (reservaToUpdate.getDesde().isAfter(reservaToUpdate.getHasta())){
            throw new DateConflictException("La hora de inicio debe ser anterior a la hora de finalización");
        }
        Optional<FechaEspecial> fechaEspDeFinca = fechaEspecialModelService.getFechaEspecialByFincaIdAndFecha(newData.getFinca().getId(), reservaToUpdate.getFecha());
        if (fechaEspDeFinca.isPresent()){
            FechaEspecial fecha = fechaEspDeFinca.get();
            reservaModelService.validarFechaEspecial(fecha, reservaToUpdate);
        } else {
            List<Horario> horariosDeFinca = horarioModelService.getAllHorariosByFincaIdAndDayOfWeek(newData.getFinca().getId(), reservaToUpdate.getDiaSemana());
            if (horariosDeFinca.isEmpty()) {
                throw new DateConflictException("La finca no esta disponible en ese horario");
            }
            reservaModelService.validarHorario(reservaToUpdate, horariosDeFinca);
        }
        List<Reserva> reservasAnteriores = reservaModelService.getReservasByFincaIdAndFecha(reservaToUpdate.getFinca().getId(), reservaToUpdate.getFecha());
        reservaModelService.validarReservasAnteriores(reservaToUpdate, reservasAnteriores);

        Reserva reservaUpdated = reservaModelService.updateReserva(reservaId, reservaToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + reservaId));

        return Optional.of(reservaDTOMapper.toDto(reservaUpdated));
    }

    @Override
    public boolean deleteById(Long reservaId) {
        return reservaModelService.deleteReserva(reservaId);
    }

    @Override
    public List<ReservaResponseDTO> getReservasByFincaIdAndFecha(Long fincaId, LocalDate fecha) {
        List<Reserva> reservas = reservaModelService.getReservasByFincaIdAndFecha(fincaId, fecha);
        return reservaDTOMapper.toDtoList(reservas);
    }
}
