package com.example.finca_hexagonal.domain.ports.out;



import com.example.finca_hexagonal.domain.models.Fecha_Especial;

import java.util.List;
import java.util.Optional;

public interface Fecha_EspecialModelPort {

    Fecha_Especial save(Fecha_Especial fecha_Especial);

    List<Fecha_Especial> getAll();

    Optional<Fecha_Especial> getById(Long id_fecha);

    Fecha_Especial update(Fecha_Especial fecha_Especial);

    boolean delete(Long id_fecha);

<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 8211f84 (Direccion y Fecha_Especial)
=======

>>>>>>> 06956d0 (cambios prueba)
    Fecha_Especial logicalDelete(Fecha_Especial fecha_Especial);

}
