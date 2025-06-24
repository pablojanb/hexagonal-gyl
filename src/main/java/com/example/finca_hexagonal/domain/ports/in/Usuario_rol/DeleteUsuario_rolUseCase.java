package domain.ports.in.Usuario_rol;

import domain.models.Documentacion;

public interface DeleteUsuario_rolUseCase {
    Boolean delete(int id);
    Documentacion logicalDeletion();
}
