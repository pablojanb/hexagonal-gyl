package com.example.finca_hexagonal.application.services.HorarioService.impl;

import com.example.finca_hexagonal.application.dto.horarios.HorarioRequestDTO;
import com.example.finca_hexagonal.application.dto.horarios.HorarioResponseDTO;
import com.example.finca_hexagonal.application.mappers.HorarioDTOMapper;
import com.example.finca_hexagonal.application.services.HorarioService.HorarioService;
import com.example.finca_hexagonal.domain.models.Horario;

import java.util.List;
import java.util.Optional;

public class HorarioServiceImpl implements HorarioService {

    private HorarioModelService horarioModelService;
    private HorarioDTOMapper horarioDTOMapper;

    @Override
    public HorarioResponseDTO createHorario(HorarioRequestDTO horarioDTO) {
        Horario horario = horarioDTOMapper.toModel(horarioDTO);
        Horario newHorario = horarioModelService.createHorario(horario);
        return horarioDTOMapper.toDto(newHorario);
    }

    @Override
    public List<HorarioResponseDTO> getAllHorarios() {
        List<Horario> horarios = horarioModelService.getAllHorarios();
        return horarioDTOMapper.toDtoList(horarios);
    }

    @Override
    public Optional<HorarioResponseDTO> getHorarioById(Long horarioId) {
        return Optional.empty();
    }

    @Override
    public boolean deleteHorario(Long horarioId) {
        return horarioModelService.deleteHorario(horarioId);
    }

    @Override
    public Optional<HorarioResponseDTO> updateHorario(Long horarioId, HorarioRequestDTO horarioDTO) {
        return Optional.empty();
    }
}
