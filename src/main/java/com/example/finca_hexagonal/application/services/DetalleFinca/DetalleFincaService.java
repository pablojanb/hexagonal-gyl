package com.example.finca_hexagonal.application.services.DetalleFinca;

import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTORequest;
import com.example.finca_hexagonal.application.dto.detalleFinca.DetalleFincaDTOResponse;

import java.util.List;
import java.util.Optional;

public interface DetalleFincaService {
    DetalleFincaDTOResponse save(DetalleFincaDTORequest detalle);

    Optional<DetalleFincaDTOResponse> findById(Long id);

    List<DetalleFincaDTOResponse> findAll();

    Optional<DetalleFincaDTOResponse> update(Long id, DetalleFincaDTORequest detalle);

    boolean delete(Long id);
}
