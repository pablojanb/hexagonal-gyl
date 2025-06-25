package domain.ports.in.Usuario;

import domain.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface FindUsuarioUseCase {
    List<Usuario> getAll();

    Optional<Usuario> getById(int id);

    Optional<Usuario> getByName(String nombre_usuario);

}
