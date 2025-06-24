package com.example.finca_hexagonal.domain.ports.in.finca;

import com.example.finca_hexagonal.domain.models.DetalleFinca;
import java.util.List;

public interface DetalleFincaService {
    DetalleFinca crearDetalle(DetalleFinca detalle);
    DetalleFinca obtenerPorId(Long id);
    List<DetalleFinca> listarTodos();
    DetalleFinca actualizarDetalle(DetalleFinca detalle);
    void eliminarDetalle(Long id);
}
