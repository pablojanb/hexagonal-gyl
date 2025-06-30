package com.example.finca_hexagonal.application.services.FincaService.impl;

import com.example.finca_hexagonal.application.dto.fincas.FincaRequestDTO;
import com.example.finca_hexagonal.application.dto.fincas.FincaResponseDTOSimplified;
import com.example.finca_hexagonal.application.mappers.FincaDTOMapper;
import com.example.finca_hexagonal.application.services.FincaService.FincaService;
import com.example.finca_hexagonal.domain.models.Finca;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FincaServiceImpl implements FincaService {


    @Override
    public FincaResponseDTOSimplified createFinca(FincaRequestDTO fincaDto) {
        return null;
    }

    @Override
    public List<FincaResponseDTOSimplified> getAllFincas() {
        return List.of();
    }

    @Override
    public Optional<FincaResponseDTOSimplified> getFincaById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<FincaResponseDTOSimplified> updateFinca(Long id, FincaRequestDTO fincaDto) {
        return Optional.empty();
    }

    @Override
    public boolean deleteFincaById(Long id) {
        return false;
    }

    /*
    private final FincaDTOMapper fincaDTOMapper;

    public FincaServiceImpl(FincaModelService fincaModelService, FincaDTOMapper fincaDTOMapper) {
        this.fincaModelService = fincaModelService;
        this.fincaDTOMapper = fincaDTOMapper;
    }

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
        return Optional.empty();
    }

    @Override
    public Optional<FincaResponseDTOSimplified> updateFinca(Long id, FincaRequestDTO fincaDto) {
        return Optional.empty();
    }

    @Override
    public boolean deleteFincaById(Long id) {
        return fincaModelService.deleteFincaById(id);
    }


     */
}
