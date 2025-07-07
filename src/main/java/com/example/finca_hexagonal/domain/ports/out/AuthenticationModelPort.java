package com.example.finca_hexagonal.domain.ports.out;

import com.example.finca_hexagonal.domain.models.Usuario;

public interface AuthenticationModelPort {
    Usuario findByEmail(String email, String password);
}
