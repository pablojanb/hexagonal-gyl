package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.domain.ports.out.DireccionModelPort;
import com.example.finca_hexagonal.infrastructure.mappers.DireccionMappers;
import com.example.finca_hexagonal.infrastructure.repositories.JpaDireccionRepository;

import java.util.List;
import java.util.Optional;

public class DireccionRepositoryAdapter implements DireccionModelPort {
    private final JpaDireccionRepository direccionRepository;
    private final DireccionMappers direccionMappers;

    public DireccionRepositoryAdapter(JpaDireccionRepository direccionRepository, DireccionMappers direccionMappers) {
        this.direccionRepository = direccionRepository;
        this.direccionMappers = direccionMappers;
    }

    @Override
    public Direccion save(Direccion direccion) {
        return null;
    }

    @Override
    public List<Direccion> findAll() {
        return List.of();
    }

    @Override
    public Optional<Direccion> findById(Long id_direccion) {
        return Optional.empty();
    }

    @Override
    public Optional<Direccion> findByAltura(int altura) {
        return Optional.empty();
    }

    @Override
    public Direccion update(Direccion direccion) {
        return null;
    }

    @Override
    public boolean delete(Long id_direccion) {
        return false;
    }
}
