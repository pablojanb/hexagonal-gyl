package domain.ports.out;

import domain.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioModelPort {
    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(int id);

    Optional<Usuario> findByName(String nombre_usuario);

    Usuario update(Usuario usuario);

    Boolean delete(int id);

    Usuario logicalDeletion(Usuario usuario);
}
