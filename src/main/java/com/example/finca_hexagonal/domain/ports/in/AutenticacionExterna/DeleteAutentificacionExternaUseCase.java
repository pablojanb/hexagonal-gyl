package domain.ports.in.AutenticacionExterna;

import domain.models.AutenticacionExterna;

public interface DeleteAutentificacionExternaUseCase {
    Boolean delete (int id);

    AutenticacionExterna logicalDeletion(AutenticacionExterna autenticacionExterna);
}
