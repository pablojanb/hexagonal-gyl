package com.example.finca_hexagonal.infrastructure.utils;

import com.example.finca_hexagonal.domain.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Password {
    public static String hashPassword(String password){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 1024, 1, password);
    }

    public static boolean verificarPassword(String password, Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(usuario.getPassword(), password);
    }
}
