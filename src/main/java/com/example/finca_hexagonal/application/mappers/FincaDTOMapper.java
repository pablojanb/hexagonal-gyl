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

//@Mapper(componentModel = "spring")
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

    @Mapping(source = "id_propietario", target = "propietario", qualifiedByName = "mapPropietarioDtoToPropietario")
    @Mapping(source = "id_detalleFinca", target = "detalle", qualifiedByName = "mapDetalleDtoTodetalle")
    @Mapping(source = "id_direccion", target = "direccion", qualifiedByName = "mapDireccionDtodireccion")
    public abstract Finca toModel(FincaRequestDTO fincaDto);

    @Mapping(source = "propietario.id", target = "id_propietario")
    @Mapping(source = "propietario.nombre", target = "propietario")
    @Mapping(source = "direccion.id", target = "id_direccion")
    @Mapping(source = "direccion.calle", target = "direccion")
    @Mapping(source = "detalle.id", target = "id_detalle")
    public abstract FincaResponseDTOSimplified toDtoSimplified(Finca finca);

    public abstract List<FincaResponseDTOSimplified> toDtoSimplifiedList(List<Finca> finca);

    @Mapping(source = "propietario.id", target = "id_propietario")
    @Mapping(source = "detalle.id", target = "id_detalle")
    @Mapping(source = "direccion.id", target = "id_direccion")
    @Mapping(source = "propietario.nombre", target = "propietario")
    @Mapping(source = "direccion.calle", target = "direccion")
    public abstract FincaResponseDTO toDto(Finca finca);


/*
    @Named("mapPropietarioDtoToPropietario")
    protected Propietario mapPropietarioDtoToPropietario(Long id_propietario) {
        return propietarioModelService.getById(id_propietario)
                .orElseThrow(() -> new IllegalArgumentException("Propietario not found: " + id_propietario));
    }

    @Named("mapDetalleDtoTodetalle")
    protected Detalle mapDetalleDtoTodetalle(Long id_detalleFinca) {
        return detalleModelService.getById(id_detalleFinca)
                .orElseThrow(() -> new IllegalArgumentException("Detalle not found: " + id_detalleFinca));
    }

    @Named("mapDireccionDtodireccion")
    protected Direccion mapDireccionDtodireccion(Long id_direccion) {
        return direccionModelService.getById(id_direccion)
                .orElseThrow(() -> new IllegalArgumentException("Direccion not found: " + id_direccion));
    }

 */

}
