package domain.ports.in.Cliente;

import domain.models.Cliente;

public interface CreateClienteUseCase {
    Cliente create (Cliente cliente);
}

