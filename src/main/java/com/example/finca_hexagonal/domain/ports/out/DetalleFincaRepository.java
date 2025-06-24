package com.example.finca_hexagonal.domain.ports.out;
import com.example.finca_hexagonal.domain.models.DetalleFinca;

import java.util.List;
import java.util.Optional;

public interface DetalleFincaRepository {
    DetalleFinca guardar(DetalleFinca detalle);
    Optional<DetalleFinca> buscarPorId(Long id);
    List<DetalleFinca> buscarTodos();
    DetalleFinca actualizar(DetalleFinca detalle);
    void eliminar(Long id);
}

