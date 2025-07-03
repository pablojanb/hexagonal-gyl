package com.example.finca_hexagonal.application.services.imagenFinca;

import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTORequest;
import com.example.finca_hexagonal.application.dto.imagenFinca.ImagenFincaDTOResponse;

import java.util.List;
import java.util.Optional;

public interface ImagenFincaService {
    ImagenFincaDTOResponse createImagen(ImagenFincaDTORequest imagen);

    Optional<ImagenFincaDTOResponse> getById(Long id);

    Optional<ImagenFincaDTOResponse> updateById(Long id, ImagenFincaDTORequest imagenFincaUpdate);

    List<ImagenFincaDTOResponse> getByFincaId(Long fincaId);

    boolean deleteById(Long id);
}
