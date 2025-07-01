package com.example.finca_hexagonal.application.services.FincaService.impl;

import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTOSimplified;
import com.example.finca_hexagonal.application.mappers.FincaDTOMapper;
import com.example.finca_hexagonal.application.services.FincaService.FincaService;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.infrastructure.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincaServiceImpl implements FincaService {

    @Autowired
    private FincaModelService fincaModelService;
    @Autowired
    private FincaDTOMapper fincaDTOMapper;

    @Override
    public FincaResponseDTOSimplified createFinca(FincaRequestDTO fincaDto) {
        Finca finca = fincaDTOMapper.toModel(fincaDto);
        Finca newFinca = fincaModelService.createFinca(finca);
        return fincaDTOMapper.toDtoSimplified(newFinca);
    }

    @Override
    public List<FincaResponseDTOSimplified> getAllFincas() {
        List<Finca> fincas = fincaModelService.getAllFincas();
        return fincaDTOMapper.toDtoSimplifiedList(fincas);
    }

    @Override
    public Optional<FincaResponseDTOSimplified> getFincaById(Long id) {
        Finca finca = fincaModelService.getFincaById(id)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + id));
        return Optional.of(fincaDTOMapper.toDtoSimplified(finca));
    }

    @Override
    public Optional<FincaResponseDTOSimplified> updateFinca(Long id, FincaRequestDTO fincaDto) {
        Finca fincaToUpdate = fincaModelService.getFincaById(id)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + id));
        Finca newData = fincaDTOMapper.toModel(fincaDto);
        fincaToUpdate.setNombre(newData.getNombre());
        fincaToUpdate.setUsuario(newData.getUsuario());
        fincaToUpdate.setDireccion(newData.getDireccion());
        fincaToUpdate.setTarifaHora(fincaDto.getTarifaHora());
        Finca fincaUpdated = fincaModelService.updateFinca(id, fincaToUpdate)
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + id));

        return Optional.of(fincaDTOMapper.toDtoSimplified(fincaUpdated));
    }

    @Override
    public boolean deleteFincaById(Long id) {
        return fincaModelService.deleteFincaById(id);
    }
}
