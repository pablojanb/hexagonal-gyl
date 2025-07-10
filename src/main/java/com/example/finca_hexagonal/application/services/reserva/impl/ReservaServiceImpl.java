package com.example.finca_hexagonal.application.services.reserva.impl;

import com.example.finca_hexagonal.application.dto.reservas.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.application.mappers.ReservaDTOMapper;
import com.example.finca_hexagonal.application.services.fechaEspecial.impl.FechaEspecialModelService;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.application.services.reserva.ReservaService;
import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaModelService reservaModelService;
    private final ReservaDTOMapper reservaDTOMapper;
    private final FincaModelService fincaModelService;
    private final FechaEspecialModelService fechaEspecialModelService;

    public ReservaServiceImpl(ReservaModelService reservaModelService, ReservaDTOMapper reservaDTOMapper, FincaModelService fincaModelService, FechaEspecialModelService fechaEspecialModelService) {
        this.reservaModelService = reservaModelService;
        this.reservaDTOMapper = reservaDTOMapper;
        this.fincaModelService = fincaModelService;
        this.fechaEspecialModelService = fechaEspecialModelService;
    }

    @Override
    public ReservaResponseDTO create(ReservaRequestDTO reservaDto) {
        Finca finca = fincaModelService.getFincaById(reservaDto.getIdFinca())
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + reservaDto.getIdFinca()));
        Reserva reserva = reservaDTOMapper.toModel(reservaDto);
        BigDecimal montoBase = reservaModelService.calcularTotalReserva(reserva);
        reserva.setTotal(montoBase);
        List<FechaEspecial> fechasEspDeFinca = fechaEspecialModelService.getFechasEspByFincaId(finca.getId());
        for (FechaEspecial fecha : fechasEspDeFinca) {
            if (fecha.getFecha().isEqual(reserva.getFecha())) {
                reserva.setTotal(montoBase.add(fecha.getRecargo()).subtract(fecha.getDescuento()));
            }
        }
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
        reservaToUpdate.setTotal(newData.getTotal());
        reservaToUpdate.setEstadoReserva(newData.getEstadoReserva());
        Reserva reservaUpdated = reservaModelService.updateReserva(reservaId, reservaToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + reservaId));

        return Optional.of(reservaDTOMapper.toDto(reservaUpdated));
    }

    @Override
    public boolean deleteById(Long reservaId) {
        return reservaModelService.deleteReserva(reservaId);
    }
}
