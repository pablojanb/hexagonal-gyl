package com.example.finca_hexagonal.application.services.DetalleFinca;

import com.example.finca_hexagonal.application.dto.DetalleFinca.DetalleFincaDTORequest;
import com.example.finca_hexagonal.application.dto.DetalleFinca.DetalleFincaDTOResponse;

import java.util.List;
import java.util.Optional;

public interface DetalleFincaService {

    DetalleFincaDTOResponse create(DetalleFincaDTORequest DetalleFincaDTO);

    List<DetalleFincaDTOResponse> getAll();

    Optional<DetalleFincaDTOResponse> getById(Long id);

    Optional<DetalleFincaDTOResponse> update(Long id, DetalleFincaDTORequest detalleFincaDTORequest);

    boolean delete(Long id);
}
