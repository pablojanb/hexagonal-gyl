package domain.ports.out;

import domain.models.Usuario_rol;

import java.util.List;
import java.util.Optional;

public interface Usuario_rolModelPort {

    Usuario_rol save(Usuario_rol usuario_rol);

    List<Usuario_rol> findAll();

    Optional<Usuario_rol> findById(int id);


    Usuario_rol update(Usuario_rol usuario_rol);

    Boolean delete(int id);

    Usuario_rol logicalDeletion(Usuario_rol usuario_rol);
}
