package domain.ports.in.Documentacion;

import domain.models.Documentacion;

public interface DeleteDocumentacionUseCase {
    Boolean delete(int id);
    Documentacion logicalDeletion(Documentacion documentacion);
}
