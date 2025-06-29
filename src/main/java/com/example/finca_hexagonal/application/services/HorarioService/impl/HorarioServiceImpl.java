package com.example.finca_hexagonal.application.services.HorarioService.impl;

import com.example.finca_hexagonal.application.dto.horarios.HorarioRequestDTO;
import com.example.finca_hexagonal.application.dto.horarios.HorarioResponseDTO;
import com.example.finca_hexagonal.application.mappers.HorarioDTOMapper;
import com.example.finca_hexagonal.application.services.FincaService.impl.FincaModelService;
import com.example.finca_hexagonal.application.services.HorarioService.HorarioService;
import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.models.Horario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {

    private final HorarioModelService horarioModelService;
    private final FincaModelService fincaModelService;
    private final HorarioDTOMapper horarioDTOMapper;

    public HorarioServiceImpl(HorarioModelService horarioModelService, FincaModelService fincaModelService, HorarioDTOMapper horarioDTOMapper) {
        this.horarioModelService = horarioModelService;
        this.fincaModelService = fincaModelService;
        this.horarioDTOMapper = horarioDTOMapper;
    }

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
    public List<HorarioResponseDTO> getAllHorariosByFincaId(Long id) {
        List<Horario> horarios = horarioModelService.getAllHorariosByFincaId(id);
        return horarioDTOMapper.toDtoList(horarios);
    }

    @Override
    public List<HorarioResponseDTO> getAllHorariosByFincaIdAndDayOfWeek(Long id, String dayOfWeek) {
        List<Horario> horarios = horarioModelService.getAllHorariosByFincaIdAndDayOfWeek(id, dayOfWeek);
        return horarioDTOMapper.toDtoList(horarios);
    }

    @Override
    public Optional<HorarioResponseDTO> getHorarioById(Long horarioId) {
        Horario horario = horarioModelService.getHorarioById(horarioId)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado: " + horarioId));
        return Optional.of(horarioDTOMapper.toDto(horario));
    }

    @Override
    public boolean deleteHorario(Long horarioId) {
        return horarioModelService.deleteHorario(horarioId);
    }

    @Override
    public Optional<HorarioResponseDTO> updateHorario(Long horarioId, HorarioRequestDTO horarioDTO) {
        Horario horario = horarioModelService.getHorarioById(horarioId)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado: " + horarioId));
        horario.setDiaSemana(horarioDTO.getDiaSemana());
        horario.setHoraInicio(horarioDTO.getHoraInicio());
        horario.setHoraFin(horarioDTO.getHoraFin());
        horario.setRecargo(horarioDTO.getRecargo());
        horario.setDescuento(horarioDTO.getDescuento());
        Finca finca = fincaModelService.getFincaById(horarioDTO.getIdFinca())
                .orElseThrow(() -> new EntityNotFoundException("Finca no encontrada: " + horarioDTO.getIdFinca()));
        horario.setFinca(finca);
        Horario updatedHorario = horarioModelService.updateHorario(horarioId, horario)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado: " + horarioId));
        return Optional.of(horarioDTOMapper.toDto(updatedHorario));
    }
}
