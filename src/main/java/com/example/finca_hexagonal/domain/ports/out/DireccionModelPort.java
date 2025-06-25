package com.example.finca_hexagonal.domain.ports.out;



import com.example.finca_hexagonal.domain.models.Direccion;

import java.util.List;
import java.util.Optional;

public interface DireccionModelPort {

    Direccion save(Direccion direccion);
    List<Direccion> findAll();

    Optional<Direccion> findById(Long id_direccion);

    Optional<Direccion> findByAltura(int altura);

    Direccion update(Direccion direccion);

    boolean delete(Long id_direccion);


}
