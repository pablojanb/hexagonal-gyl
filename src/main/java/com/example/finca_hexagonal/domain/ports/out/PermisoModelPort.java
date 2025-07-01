package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Permiso;

import java.util.List;
import java.util.Optional;

public interface PermisoModelPort {
    Permiso save(Permiso permiso);

    List<Permiso> findAll();

    Permiso findById(Long id);
    
    Permiso update(Permiso permiso);

    Boolean deleteById(Long id);

}
