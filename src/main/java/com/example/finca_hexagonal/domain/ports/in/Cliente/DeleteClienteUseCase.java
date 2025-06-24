package domain.ports.in.Cliente;

import domain.models.Cliente;

public interface DeleteClienteUseCase {
    Boolean delete(int id);
    Cliente logicalDeletion(Cliente cliente);
}
