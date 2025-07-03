package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTORequest;
import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTOResponse;
import com.example.finca_hexagonal.application.services.FincaService.impl.FincaModelService;
import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.models.Finca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DetalleFincaDTOMapper {

    @Autowired
    private FincaModelService fincaModelService;

    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapFincaDtoToFinca")
    public abstract DetalleFinca toModel(DetalleFincaDTORequest detalleDto);

    @Mapping(source = "finca.id", target = "idFinca")
    @Mapping(source = "finca.nombre", target = "finca")
    public abstract DetalleFincaDTOResponse toDto(DetalleFinca detalle);

    public abstract List<DetalleFincaDTOResponse> toDtoList(List<DetalleFinca> detalles);

    @Named("mapFincaDtoToFinca")
    protected Finca mapFincaDtoToFinca(Long id_finca) {
        return fincaModelService.getFincaById(id_finca)
                .orElseThrow(() -> new IllegalArgumentException("Finca no encontrada: " + id_finca));
    }
}
