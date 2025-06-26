package com.example.finca_hexagonal.application.services;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import com.example.finca_hexagonal.domain.ports.in.finca.DetalleFincaService;
import com.example.finca_hexagonal.domain.ports.out.DetalleFincaModelPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFincaServiceImpl implements DetalleFincaService {

    private final DetalleFincaModelPort repository;

    public DetalleFincaServiceImpl(DetalleFincaModelPort repository) {
        this.repository = repository;
    }

    @Override
    public DetalleFinca crearDetalle(DetalleFinca detalle) {
        return repository.guardar(detalle);
    }

    @Override
    public DetalleFinca obtenerPorId(Long id) {
        return repository.buscarPorId(id).orElse(null);
    }

    @Override
    public List<DetalleFinca> listarTodos() {
        return repository.buscarTodos();
    }

    @Override
    public DetalleFinca actualizarDetalle(DetalleFinca detalle) {
        return repository.actualizar(detalle);
    }

    @Override
    public void eliminarDetalle(Long id) {
        repository.eliminar(id);
    }
}
