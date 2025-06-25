package domain.ports.in.Contacto;

import domain.models.Propietario;

public interface DeleteContactoUseCase {
    Boolean delete(int id);

    Propietario logicalDeletion(Propietario propietario);
}
