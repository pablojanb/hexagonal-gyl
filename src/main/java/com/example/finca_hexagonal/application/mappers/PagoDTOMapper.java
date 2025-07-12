package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.example.finca_hexagonal.application.services.reserva.impl.ReservaModelService;
import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.models.enums.MedioPago;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PagoDTOMapper {

    @Autowired
    protected ReservaModelService reservaModelService;


    @Mapping(source = "reservaId", target = "reserva", qualifiedByName = "mapReservaFromId")
    public abstract Pago toModel(PagoRequestDTO dto);

    @Mapping(source = "reserva.id", target = "idReserva")
    @Mapping(source = "montoTotal", target = "montoTotalConImpuestos")
    @Mapping(source = "medioPago", target = "medioPago", qualifiedByName = "mapMedioPago")
    public abstract PagoResponseDTO toDto(Pago pago);

    public abstract List<PagoResponseDTO> toDtoList(List<Pago> pagos);

    @Named("mapReservaFromId")
    protected Reserva mapReservaFromId(Long reservaId) {
        return reservaModelService.getReservaById(reservaId)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada con ID: " + reservaId));
    }

    @Named("mapMedioPago")
    protected MedioPago mapMedioPago(MedioPago medioPago) {
        return medioPago;
    }
}
