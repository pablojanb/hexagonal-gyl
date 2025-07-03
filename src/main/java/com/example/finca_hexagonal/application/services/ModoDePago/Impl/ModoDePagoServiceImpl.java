package com.example.finca_hexagonal.application.services.ModoDePago.Impl;

import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoRequestDTO;
import com.example.finca_hexagonal.application.dto.modoDePago.ModoDePagoResponseDTO;
import com.example.finca_hexagonal.application.mappers.ModoDePagoDTOMapper;
import com.example.finca_hexagonal.application.services.ModoDePago.ModoDePagoService;
import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.CreateModoDepagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.DeleteModoDePagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.GetModoDePagoUseCase;
import com.example.finca_hexagonal.domain.ports.in.modoDePago.UpdateModoDePagoUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModoDePagoServiceImpl implements ModoDePagoService {

    private final CreateModoDepagoUseCase createUseCase;
    private final GetModoDePagoUseCase getUseCase;
    private final UpdateModoDePagoUseCase updateUseCase;
    private final DeleteModoDePagoUseCase deleteUseCase;
    private final ModoDePagoDTOMapper mapper;

    public ModoDePagoServiceImpl(
            CreateModoDepagoUseCase createUseCase,
            GetModoDePagoUseCase getUseCase,
            UpdateModoDePagoUseCase updateUseCase,
            DeleteModoDePagoUseCase deleteUseCase,
            ModoDePagoDTOMapper mapper) {
        this.createUseCase = createUseCase;
        this.getUseCase = getUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
        this.mapper = mapper;
    }

    @Override
    public ModoDePagoResponseDTO create(ModoDePagoRequestDTO dto) {
        ModoDePago saved = createUseCase.save(mapper.toModel(dto));
        return mapper.toDto(saved);
    }

    @Override
    public List<ModoDePagoResponseDTO> getAll() {
        return mapper.toDtoList(getUseCase.getAll());
    }

    @Override
    public Optional<ModoDePagoResponseDTO> getById(Long id) {
        return getUseCase.getById(id).map(mapper::toDto);
    }

    @Override
    public Optional<ModoDePagoResponseDTO> updateById(Long id, ModoDePagoRequestDTO dto) {
        return updateUseCase.updateById(id, mapper.toModel(dto)).map(mapper::toDto);
    }

    @Override
    public boolean delete(Long id) {
        return deleteUseCase.deleteById(id);
    }
}
