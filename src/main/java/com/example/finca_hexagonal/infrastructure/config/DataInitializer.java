package com.example.finca_hexagonal.infrastructure.config;

import com.example.finca_hexagonal.infrastructure.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataInitializer implements ApplicationRunner {

    private final EntityManager entityManager;

    public DataInitializer(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {

        // Crear Direcciones
        DireccionEntity direccion = new DireccionEntity();
        direccion.setAclaracion("Aclaracion direccion 1");
        direccion.setAltura(323);
        direccion.setCalle("Congresales");
        direccion.setCiudad("Buenos Aires");
        direccion.setProvincia("Buenos Aires");
        entityManager.persist(direccion);

        DireccionEntity direccion2 = new DireccionEntity();
        direccion2.setAclaracion("Aclaracion direccion 2");
        direccion2.setAltura(454);
        direccion2.setCalle("Lopez rega");
        direccion2.setCiudad("Rio cuarto");
        direccion2.setProvincia("Cordoba");
        entityManager.persist(direccion2);

        DireccionEntity direccion3 = new DireccionEntity();
        direccion3.setAclaracion("Aclaracion direccion 3");
        direccion3.setAltura(112);
        direccion3.setCalle("Los Gladiolos");
        direccion3.setCiudad("Rosario");
        direccion3.setProvincia("Santa fe");
        entityManager.persist(direccion3);

        System.out.println("✅ Datos iniciales insertados correctamente.");

    }
}
