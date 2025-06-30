package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTOSimplified;
import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.Propietario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FincaDTOMapper {

    /*
    private final PropietarioModelService propietarioModelService;
    private final DireccionModelService direccionModelService;
    private final DetalleModelService detalleModelService;

    public FincaDTOMapper(PropietarioModelService propietarioModelService, DireccionModelService direccionModelService, DetalleModelService detalleModelService){
        this.propietarioModelService = propietarioModelService;
        this.direccionModelService = direccionModelService;
        this.detalleModelService = detalleModelService;

     */

    @Mapping(source = "idPropietario", target = "propietario", qualifiedByName = "mapPropietarioDtoToPropietario")
    @Mapping(source = "idDetalleFinca", target = "detalle", qualifiedByName = "mapDetalleDtoToDetalle")
    @Mapping(source = "idDireccion", target = "direccion", qualifiedByName = "mapDireccionDtoDireccion")
    public abstract Finca toModel(FincaRequestDTO fincaDto);

    @Mapping(source = "propietario.id", target = "idPropietario")
    @Mapping(source = "detalle.id", target = "idDetalle")
    @Mapping(source = "direccion.id", target = "idDireccion")
    @Mapping(source = "propietario.nombre", target = "propietario")
    @Mapping(source = "direccion.calle", target = "direccion")
    public abstract FincaResponseDTOSimplified toDtoSimplified(Finca finca);

    public abstract List<FincaResponseDTOSimplified> toDtoSimplifiedList(List<Finca> finca);

    @Mapping(source = "propietario.id", target = "idPropietario")
    @Mapping(source = "detalle.id", target = "idDetalle")
    @Mapping(source = "direccion.id", target = "idDireccion")
    @Mapping(source = "propietario.nombre", target = "propietario")
    @Mapping(source = "direccion.calle", target = "direccion")
    public abstract FincaResponseDTO toDto(Finca finca);


/*
    @Named("mapPropietarioDtoToPropietario")
    protected Propietario mapPropietarioDtoToPropietario(Long idPropietario) {
        return propietarioModelService.getById(idPropietario);
    }

    @Named("mapDetalleDtoToDetalle")
    protected DetalleFinca mapDetalleDtoToDetalle(Long idDetalleFinca) {
        return detalleModelService.getById(idDetalleFinca);
    }

    @Named("mapDireccionDtoDireccion")
    protected Direccion mapDireccionDtoDireccion(Long idDireccion) {
        return direccionModelService.getById(idDireccion);
    }

 */

}
