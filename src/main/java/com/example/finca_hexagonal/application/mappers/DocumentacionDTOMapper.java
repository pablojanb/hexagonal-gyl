package com.example.finca_hexagonal.application.mappers;

import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionRequestDTO;
import com.example.finca_hexagonal.application.dto.documentacion.DocumentacionResponseDTO;
import com.example.finca_hexagonal.application.services.finca.impl.FincaModelService;
import com.example.finca_hexagonal.domain.models.Documentacion;
import com.example.finca_hexagonal.domain.models.Finca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DocumentacionDTOMapper {

    @Autowired
    private FincaModelService fincaModelService;

    @Mapping(source = "fincaId", target = "finca", qualifiedByName = "mapFincaDtoToFinca")
    public abstract Documentacion toModel(DocumentacionRequestDTO documentacionDto);

    @Mapping(source = "finca.id", target = "fincaId")
    @Mapping(source = "finca.nombre", target = "finca")
    @Mapping(source = "finca.usuario.nombre", target = "propietario")
    public abstract DocumentacionResponseDTO toDto(Documentacion documentacion);

    public abstract List<DocumentacionResponseDTO> toDtoList(List<Documentacion> documentaciones);

    @Named("mapFincaDtoToFinca")
    protected Finca mapFincaDtoToFinca(Long id_finca) {
        return fincaModelService.getFincaById(id_finca)
                .orElseThrow(() -> new IllegalArgumentException("Finca no encontrada: " + id_finca));
    }
}
