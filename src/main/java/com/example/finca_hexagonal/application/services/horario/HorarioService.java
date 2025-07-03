package com.example.finca_hexagonal.application.services.horario;

import com.example.finca_hexagonal.application.dto.horarios.HorarioRequestDTO;
import com.example.finca_hexagonal.application.dto.horarios.HorarioResponseDTO;

import java.util.List;
import java.util.Optional;

public interface HorarioService {
    HorarioResponseDTO createHorario(HorarioRequestDTO horarioDTO);

    List<HorarioResponseDTO> getAllHorarios();

    List<HorarioResponseDTO> getAllHorariosByFincaId(Long id);

    List<HorarioResponseDTO> getAllHorariosByFincaIdAndDayOfWeek(Long id, String dayOfWeek);

    Optional<HorarioResponseDTO> getHorarioById(Long horarioId);

    boolean deleteHorario(Long horarioId);

    Optional<HorarioResponseDTO> updateHorario(Long horarioId, HorarioRequestDTO horarioDTO);
}
