package domain.ports.in.AutenticacionExterna;

import domain.models.AutenticacionExterna;

public interface CreateAutenticacionExternaUseCase {
    AutenticacionExterna create(AutenticacionExterna autenticacionExterna);
}
