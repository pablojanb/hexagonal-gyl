package com.example.finca_hexagonal.application.services.fecha_especial;

// Implementa
import com.example.finca_hexagonal.application.dto.fecha_especal.Fecha_EspecialDTORequest;
import com.example.finca_hexagonal.application.dto.fecha_especal.Fecha_EspecialDTOResponse;

import java.util.List;

public interface Fecha_EspecialService {

    Fecha_EspecialDTOResponse create(Fecha_EspecialDTORequest fecha_EspecialDTORequest);

    List<Fecha_EspecialDTOResponse> getAll();

    Fecha_EspecialDTOResponse getById(Long id_fecha);

    Fecha_EspecialDTOResponse update(Long id_fecha, Fecha_EspecialDTORequest fecha_EspecialDTORequest);

    Fecha_EspecialDTOResponse delete(Long id_fecha);

    Fecha_EspecialDTOResponse logicalDelete(Long id_fecha);

}
