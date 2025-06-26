package domain.ports.in.Usuario;

import domain.models.Usuario;

public interface DeleteUsuarioUseCase {
    Boolean delete(int id);

    Usuario logicalDeletion(Usuario usuario);
}
