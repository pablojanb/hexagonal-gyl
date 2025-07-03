package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.pago.PagoRequestDTO;
import com.example.finca_hexagonal.application.dto.pago.PagoResponseDTO;
import com.example.finca_hexagonal.application.services.ModoDePago.Impl.ModoDePagoUseCaseService;
import com.example.finca_hexagonal.application.services.reserva.impl.ReservaModelService;
import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.models.Pago;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.application.services.ModoDePago.Impl.ModoDePagoServiceImpl;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PagoDTOMapper {

    @Autowired
    protected ReservaModelService reservaModelService;

//    @Autowired
//    protected ModoDePagoModelService modoDePagoModelService;


    @Mapping(source = "reservaId", target = "reserva", qualifiedByName = "mapReservaFromId")
    @Mapping(source = "medioDePagoId", target = "medioDePagoId")
    public abstract Pago toModel(PagoRequestDTO dto);

    @Mapping(source = "reserva.id", target = "idReserva")
    public abstract PagoResponseDTO toDto(Pago pago);

    public abstract List<PagoResponseDTO> toDtoList(List<Pago> pagos);

    @Named("mapReservaFromId")
    protected Reserva mapReservaFromId(Long reservaId) {
        return reservaModelService.getReservaById(reservaId)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada con ID: " + reservaId));
    }


    /*
    @Named("mapModoDePagoFromId")
    protected ModoDePago mapModoDePagoFromId(Long id) {
        return modoDePagoModelService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Modo de pago no encontrado con ID: " + id));
    }
    */
}
