package com.example.finca_hexagonal.application.services.DetalleFinca.impl;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.in.finca.DetalleFincaModelService;
import com.example.finca_hexagonal.domain.ports.out.DetalleFincaModelPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFincaServiceImpl implements DetalleFincaModelService {

    private final DetalleFincaModelPort repository;

    public DetalleFincaServiceImpl(DetalleFincaModelPort repository) {
        this.repository = repository;
    }

    @Override
    public DetalleFinca crearDetalle(DetalleFinca detalle) {
        return repository.save(detalle);
    }

    @Override
    public DetalleFinca findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DetalleFinca> listarTodos() {
        return repository.findAll();
    }

    @Override
    public DetalleFinca actualizarDetalle(DetalleFinca detalle) {
        return repository.update(detalle);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
