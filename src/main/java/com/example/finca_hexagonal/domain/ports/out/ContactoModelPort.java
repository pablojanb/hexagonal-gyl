package domain.ports.out;

import domain.models.Contacto;

import java.util.List;
import java.util.Optional;

public interface ContactoModelPort {
    Contacto save(Contacto contacto);

    List<Contacto> findAll();

    Optional<Contacto> findById(int id);

    Optional<Contacto> findByName(String email);

    Contacto update(Contacto contacto);

    Boolean delete(Long id);

    Contacto logicalDeletion(Contacto contacto);
}
