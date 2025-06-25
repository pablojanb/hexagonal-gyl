package domain.ports.out;

import domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteModelPort {

    Cliente save(Cliente cliente);

    List<Cliente> findAll();

    Optional<Cliente> findById(int id);

    Optional<Cliente> findByName(String nombre);

    Cliente update(Cliente cliente);

    Boolean delete(Long id);

    Cliente logicalDeletion(Cliente cliente);

}
