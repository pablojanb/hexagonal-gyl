package domain.ports.in.Rol;

import domain.models.Rol;

public interface DeleteRolUseCase {
    Boolean delete(int id);
    Rol logicalDeletion(Rol rol);
}
