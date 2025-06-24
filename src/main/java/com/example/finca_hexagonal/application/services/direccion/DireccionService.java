package com.example.finca_hexagonal.application.services.direccion;

import com.example.finca_hexagonal.application.dto.direccion.DireccionDTORequest;
import com.example.finca_hexagonal.application.dto.direccion.DireccionDTOResponse;

import java.util.List;


public interface DireccionService {
    DireccionDTOResponse create(DireccionDTORequest direccionDto);

    List<DireccionDTOResponse> getAll();

    DireccionDTOResponse getById(Long id_direccion);

    DireccionDTOResponse getByAltura(int altura);

    DireccionDTOResponse update(Long id_direccion, DireccionDTORequest direccionDto);

    DireccionDTOResponse delete(Long id_direccion);

    DireccionDTOResponse logicalDelete(Long id_direccion);

<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 8211f84 (Direccion y Fecha_Especial)
=======

>>>>>>> 06956d0 (cambios prueba)
}
