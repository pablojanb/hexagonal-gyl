package com.example.finca_hexagonal.domain.ports.in.direccion;

import com.example.finca_hexagonal.domain.models.Direccion;

import java.util.List;
import java.util.Optional;

public interface FindDireccionUseCase {
    List<Direccion> getAll();
    Optional<Direccion> findById(Long id_direccion);
    Optional<Direccion> findByAltura(int altura);

}
