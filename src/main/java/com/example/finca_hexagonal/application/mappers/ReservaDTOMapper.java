package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.reserva.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reserva.ReservaResponseDTO;
import com.example.finca_hexagonal.application.services.Cliente.impl.ClienteModelService;
import com.example.finca_hexagonal.application.services.FincaService.impl.FincaModelService;
import com.example.finca_hexagonal.domain.models.Cliente;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReservaDTOMapper {

    @Autowired
    private FincaModelService fincaModelService;
    @Autowired
    private ClienteModelService clienteModelService;

    @Mapping(source = "idFinca", target = "finca", qualifiedByName = "mapFincaDtoToFinca")
    @Mapping(source = "idCliente", target = "cliente", qualifiedByName = "mapClienteDtoToCliente")
    public abstract Reserva toModel(ReservaRequestDTO reservaDto);

    @Mapping(source = "finca.id", target = "idFinca")
    @Mapping(source = "finca.nombre", target = "finca")
    @Mapping(source = "cliente.id", target = "idCliente")
    @Mapping(source = "cliente.nombre", target = "cliente")
    public abstract ReservaResponseDTO toDto(Reserva reserva);

    public abstract List<ReservaResponseDTO> toDtoList(List<Reserva> reservas);

    @Named("mapFincaDtoToFinca")
    protected Finca mapFincaDtoToFinca(Long idFinca) {
        return fincaModelService.getFincaById(idFinca)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + idFinca));
    }

    @Named("mapClienteDtoToCliente")
    protected Cliente mapClienteDtoToCliente(Long idCliente) {
        return clienteModelService.getCliente(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado: " + idCliente));
    }
}