package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTORequest;
import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTOResponse;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.ImagenFinca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ImagenFincaDTOMapper {

    @Autowired
    private FincaModelService fincaModelService;

    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapFincaDtoToFinca")
    public abstract ImagenFinca toModel(ImagenFincaDTORequest imagenDto);

    @Mapping(source = "finca.id", target = "fincaid")
    @Mapping(source = "finca.nombre", target = "finca")
    public abstract ImagenFincaDTOResponse toDto(ImagenFinca imagenFinca);

    public abstract List<ImagenFincaDTOResponse> toDtoList(List<ImagenFinca> imagenes);

    @Named("mapFincaDtoToFinca")
    protected Finca mapFincaDtoToFinca(Long id_finca) {
        return fincaModelService.getFincaById(id_finca)
                .orElseThrow(() -> new IllegalArgumentException("Finca no encontrada: " + id_finca));
    }
}
