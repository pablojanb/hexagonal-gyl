package domain.ports.in.Documentacion;

import domain.models.Documentacion;

import java.util.List;
import java.util.Optional;

public interface FindDocumentacionUseCase {
    List<Documentacion> getAll();

    Optional<Documentacion> getById(int id);
}
