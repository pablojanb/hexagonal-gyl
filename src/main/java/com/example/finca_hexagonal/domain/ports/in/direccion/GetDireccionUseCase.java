package com.example.finca_hexagonal.domain.ports.in.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface GetDireccionUseCase {

    List<Direccion> getAllDirecciones();

    Optional<Direccion> getDireccionById(Long id);
}
