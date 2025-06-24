package domain.ports.out;

import domain.models.Documentacion;

import java.util.List;
import java.util.Optional;

public interface DocumentacionModelPort {

    Documentacion save(Documentacion documentacion);

    List<Documentacion> findAll();

    Optional<Documentacion> findById(int id);

    Documentacion update(Documentacion documentacion);

    Boolean delete(int id);

    Documentacion logicalDeletion(Documentacion documentacion);
}
