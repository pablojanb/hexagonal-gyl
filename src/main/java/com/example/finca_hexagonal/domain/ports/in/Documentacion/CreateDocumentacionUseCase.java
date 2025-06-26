package domain.ports.in.Documentacion;

import domain.models.Documentacion;

public interface CreateDocumentacionUseCase {
    Documentacion create(Documentacion documentacion);
}
