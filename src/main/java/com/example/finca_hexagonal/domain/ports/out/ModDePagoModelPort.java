package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.ModoDePago;
import com.example.finca_hexagonal.domain.models.Reserva;

import java.util.List;
import java.util.Optional;

public interface ModDePagoModelPort {
    ModoDePago save(ModoDePago modoDePago);

    List<ModoDePago> getAll(Long id);

    Optional<ModoDePago> getById(Long id);

    Optional<ModoDePago> findByTipo(String tipo);

    List<ModoDePago> getByPagoId(Long pago_id);

    Reserva update(Reserva reserva);

    ModoDePago delete(Long id);

    ModoDePago LogicalDeletion(ModoDePago modoDePago);

}
