package domain.ports.in.AutenticacionExterna;

import domain.models.AutenticacionExterna;

import java.util.List;
import java.util.Optional;

public interface FindAutentificacionExternaUseCase {
    List<AutenticacionExterna> getAll();

    Optional<AutenticacionExterna> getById(int id);

    Optional<AutenticacionExterna> getByName(String nombreProveedor);

}
