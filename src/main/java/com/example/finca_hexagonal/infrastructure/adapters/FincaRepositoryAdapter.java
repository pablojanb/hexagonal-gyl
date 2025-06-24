package com.example.finca_hexagonal.infrastructure.adapters;

import com.example.finca_hexagonal.domain.models.Finca;
import com.example.finca_hexagonal.domain.ports.out.FincaRespositoryPort;
import com.example.finca_hexagonal.infrastructure.mappers.FincaMappers;
import com.example.finca_hexagonal.infrastructure.repositories.FincaRepository;

import java.util.List;
import java.util.Optional;

public class FincaRepositoryAdapter implements FincaRespositoryPort {
    private final FincaRepository fincaRepository;
    private final FincaMappers fincaMappers;

    public FincaRepositoryAdapter(FincaRepository fincaRepository, FincaMappers fincaMappers) {
        this.fincaRepository = fincaRepository;
        this.fincaMappers = fincaMappers;
    }


    @Override
    public Finca save(Finca finca) {
        return null;
    }

    @Override
    public List<Finca> getAll() {
        return List.of();
    }

    @Override
    public Optional<Finca> getById(int id) {
        return null;
    }

    @Override
    public Optional<Finca> update(int id, Finca finca) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
