package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.reservas.ReservaRequestDTO;
import com.example.finca_hexagonal.application.dto.reservas.ReservaResponseDTO;
import com.example.finca_hexagonal.application.services.FincaService.impl.FincaModelService;
import com.example.finca_hexagonal.application.services.Usuario.impl.UsuarioModelService;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.Reserva;
import com.example.finca_hexagonal.domain.models.Usuario;
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
    private UsuarioModelService usuarioModelService;

    @Mapping(source = "idFinca", target = "finca", qualifiedByName = "mapFincaDtoToFinca")
    @Mapping(source = "idUsuario", target = "usuario", qualifiedByName = "mapUsuarioDtoToUsuario")
    public abstract Reserva toModel(ReservaRequestDTO reservaDto);

    @Mapping(source = "finca.id", target = "idFinca")
    @Mapping(source = "finca.nombre", target = "finca")
    @Mapping(source = "usuario.id", target = "idUsuario")
    @Mapping(source = "usuario.username", target = "usuario")
    public abstract ReservaResponseDTO toDto(Reserva reserva);

    public abstract List<ReservaResponseDTO> toDtoList(List<Reserva> reservas);

    @Named("mapFincaDtoToFinca")
    protected Finca mapFincaDtoToFinca(Long idFinca) {
        return fincaModelService.getFincaById(idFinca)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + idFinca));
    }

    @Named("mapUsuarioDtoToUsuario")
    protected Usuario mapUsuarioDtoToUsuario(Long idUsuario) {
        return usuarioModelService.getById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + idUsuario));
    }
}
