package domain.ports.in.Propietario;

import domain.models.Propietario;

import java.util.List;
import java.util.Optional;

public interface FindPropietarioUseCase {
    List<Propietario> getAll();

    Optional<Propietario> getByid(int id);

    Optional<Propietario> getByName(String nombre);
}
