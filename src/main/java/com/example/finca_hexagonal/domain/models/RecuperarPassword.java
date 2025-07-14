package com.example.finca_hexagonal.domain.models;

import java.time.LocalDateTime;

public class RecuperarPassword {
    private Long id;
    private String email;
    private String token;
    private LocalDateTime expiresAt;

    public RecuperarPassword() {
    }

    public RecuperarPassword(Long id, String email, String token, LocalDateTime expiresAt) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.expiresAt = expiresAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
