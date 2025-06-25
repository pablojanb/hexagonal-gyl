package domain.ports.in.Usuario_rol;

import domain.models.Usuario_rol;

import java.util.List;
import java.util.Optional;

public interface FindUsuario_rolUseCase {
    List<Usuario_rol> getAll();

    Optional<Usuario_rol> getById(int id);

}
