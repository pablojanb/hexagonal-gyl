package domain.ports.out;

import domain.models.AutenticacionExterna;

import java.util.List;
import java.util.Optional;

public interface AutenticacionExternaModelPort {

    AutenticacionExterna save(AutenticacionExterna autenticacionExterna);

    List<AutenticacionExterna> findAll();

    Optional<AutenticacionExterna> findById(int id);

    Optional<AutenticacionExterna> findByName(String nombreProveedor);

    AutenticacionExterna update(AutenticacionExterna autenticacionExterna);

    Boolean delete(int id);

    AutenticacionExterna logicalDeletion(AutenticacionExterna autenticacionExterna);
}
