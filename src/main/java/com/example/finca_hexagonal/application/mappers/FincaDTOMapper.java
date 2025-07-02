package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTOSimplified;
import com.example.finca_hexagonal.application.services.Direccion.impl.DireccionModelService;
import com.example.finca_hexagonal.application.services.Usuario.impl.UsuarioModelService;
import com.example.finca_hexagonal.domain.models.*;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FincaDTOMapper {

    @Autowired
    private UsuarioModelService usuarioModelService;
    @Autowired
    private DireccionModelService direccionModelService;


    @Mapping(source = "idUsuario", target = "usuario", qualifiedByName = "mapUsuarioDtoToUsuario")
    @Mapping(source = "idDireccion", target = "direccion", qualifiedByName = "mapDireccionDtoDireccion")
    public abstract Finca toModel(FincaRequestDTO fincaDto);

    @Mapping(source = "usuario.id", target = "idUsuario")
    @Mapping(source = "direccion.id", target = "idDireccion")
    @Mapping(source = "usuario.username", target = "usuario")
    @Mapping(source = "direccion.direccion", target = "direccion")
    public abstract FincaResponseDTOSimplified toDtoSimplified(Finca finca);

    public abstract List<FincaResponseDTOSimplified> toDtoSimplifiedList(List<Finca> finca);

    @Mapping(source = "usuario.id", target = "idUsuario")
    @Mapping(source = "direccion.id", target = "idDireccion")
    @Mapping(source = "usuario.username", target = "usuario")
    @Mapping(source = "direccion.direccion", target = "direccion")
    public abstract FincaResponseDTO toDto(Finca finca);



    @Named("mapUsuarioDtoToUsuario")
    protected Usuario mapUsuarioDtoToUsuario(Long idUsuario) {
        return usuarioModelService.getById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + idUsuario));
    }

    @Named("mapDireccionDtoDireccion")
    protected Direccion mapDireccionDtoDireccion(Long idDireccion) {
        return direccionModelService.getDireccionById(idDireccion)
                .orElseThrow(() -> new EntityNotFoundException("Direccion no encontrada: " + idDireccion));
    }
}
