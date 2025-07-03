package com.example.finca_hexagonal.application.mappers;


import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialRequestDTO;
import com.example.finca_hexagonal.application.dto.fechaEspecial.FechaEspecialResponseDTO;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.domain.models.FechaEspecial;
import com.example.finca_hexagonal.domain.models.Finca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class FechaEspecialDTOMapper {

    @Autowired
    private FincaModelService fincaModelService;

    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapFincaDtoToFinca")
    public abstract FechaEspecial toModel(FechaEspecialRequestDTO fechaEspecialRequestDTO);

    @Mapping(source = "finca.id", target = "fincaId")
    @Mapping(source = "finca.nombre", target = "finca")
    public abstract FechaEspecialResponseDTO toDto(FechaEspecial fechaEspecial);

    public abstract List<FechaEspecialResponseDTO> toDtoList(List<FechaEspecial> fechaEspecial);


    @Named("mapFincaDtoToFinca")
    protected Finca mapFincaDtoToFinca(Long id_finca) {
        return fincaModelService.getFincaById(id_finca)
                .orElseThrow(() -> new IllegalArgumentException("Finca no encontrada: " + id_finca));
    }

}
