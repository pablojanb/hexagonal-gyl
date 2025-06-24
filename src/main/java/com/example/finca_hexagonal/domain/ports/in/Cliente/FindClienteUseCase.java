package domain.ports.in.Cliente;

import domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface FindClienteUseCase {
    List<Cliente> getAll();

    Optional<Cliente> getById(int id);
    Optional<Cliente> getByName(String nombre);

}
