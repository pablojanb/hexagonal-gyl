package domain.ports.in.Rol;

import domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface FindRolUseCase {
    List<Rol> getAll();

    Optional<Rol> getById(int id);
    Optional<Rol> getByName(String nombre);
}
