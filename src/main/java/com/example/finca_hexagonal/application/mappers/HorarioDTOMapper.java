package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.horarios.HorarioRequestDTO;
import com.example.finca_hexagonal.application.dto.horarios.HorarioResponseDTO;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class HorarioDTOMapper {

    @Autowired
    private FincaModelService fincaModelService;


    @Mapping(source = "idFinca", target = "finca", qualifiedByName = "mapFincaDtoToFinca")
    public abstract Horario toModel(HorarioRequestDTO horarioDto);


    @Mapping(source = "finca.id", target = "idFinca")
    @Mapping(source = "finca.nombre", target = "finca")
    public abstract HorarioResponseDTO toDto(Horario horario);

    public abstract List<HorarioResponseDTO> toDtoList(List<Horario> horario);


    @Named("mapFincaDtoToFinca")
    protected Finca mapFincaDtoToFinca(Long id_finca) {
        return fincaModelService.getFincaById(id_finca)
                .orElseThrow(() -> new IllegalArgumentException("Finca no encontrada: " + id_finca));
    }
}
