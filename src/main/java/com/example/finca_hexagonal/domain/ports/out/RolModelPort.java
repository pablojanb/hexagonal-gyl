package domain.ports.out;

import domain.models.Rol;

import java.util.List;
import java.util.Optional;

public interface RolModelPort {

    Rol save(Rol rol);

    List<Rol> findAll();

    Optional<Rol> findById(int id);

    Optional<Rol> findByName(String nombre);

    Rol update(Rol rol);

    Boolean delete(int id);

    Rol logicalDeletion(Rol rol);
}
