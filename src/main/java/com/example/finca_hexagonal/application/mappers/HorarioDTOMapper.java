package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.horarios.HorarioRequestDTO;
import com.example.finca_hexagonal.application.dto.horarios.HorarioResponseDTO;

import com.example.finca_hexagonal.application.services.FincaService.impl.FincaModelService;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class HorarioDTOMapper {

    private final FincaModelService fincaModelService;

    public HorarioDTOMapper(FincaModelService fincaModelService) {
        this.fincaModelService = fincaModelService;
    }

    @Mapping(source = "id_horario", target = "finca", qualifiedByName = "mapFincaDtoToFinca")
    public abstract Horario toModel(HorarioRequestDTO horarioDto);

    @Mapping(source = "finca.id", target = "id_finca")
    @Mapping(source = "finca.nombre", target = "finca")
    public abstract HorarioResponseDTO toDto(Horario horario);

    public abstract List<HorarioResponseDTO> toDtoList(List<Horario> horario);


    @Named("mapFincaDtoToFinca")
    protected Finca mapFincaDtoToFinca(Long id_finca) {
        return fincaModelService.getFincaById(id_finca)
                .orElseThrow(() -> new IllegalArgumentException("Finca no encontrada: " + id_finca));
    }
}
