package com.example.finca_hexagonal.application.services.Direccion;

import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;

import java.util.List;
import java.util.Optional;

public interface DireccionService {
    DireccionDTOResponse createDireccion(DireccionDTORequest direccionDto);

    boolean deleteById(Long id);

    Optional<DireccionDTOResponse> updateDireccionById(Long id, DireccionDTORequest updateDireccionDto);

    List<DireccionDTOResponse> getAllDirecciones();

    Optional<DireccionDTOResponse> getDireccionById(Long id);
}
