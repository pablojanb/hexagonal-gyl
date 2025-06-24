package domain.ports.in.Propietario;

import domain.models.Propietario;

public interface DeletePropietarioUseCase {
    Boolean delet(int id);

    Propietario logicalDeletion(Propietario propietario);
}
