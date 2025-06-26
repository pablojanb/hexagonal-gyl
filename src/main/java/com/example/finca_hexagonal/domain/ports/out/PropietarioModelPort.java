package domain.ports.out;

import domain.models.Propietario;

import java.util.List;
import java.util.Optional;

public interface PropietarioModelPort {
    Propietario save(Propietario propietario);

    List<Propietario> findAll();

    Optional<Propietario> findById(int id);

    Optional<Propietario> findByName(String nombre);

    Propietario update(Propietario propietario);

    Boolean delete(int id);

    Propietario logicalDeletion(Propietario propietario);
}
