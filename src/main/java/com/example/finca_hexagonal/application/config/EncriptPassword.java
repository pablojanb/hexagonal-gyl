package com.example.finca_hexagonal.application.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncriptPassword {

    public String encriptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
