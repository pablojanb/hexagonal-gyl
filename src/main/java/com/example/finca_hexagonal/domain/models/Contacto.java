package com.example.finca_hexagonal.domain.models;

public class Contacto {
    private Long id;
    private String telefono;
    private String email;
    private String emailAlternativo;

    public Contacto() {
    }

    public Contacto(Long id, String telefono, String email, String emailAlternativo) {
        this.id = id;
        this.telefono = telefono;
        this.email = email;
        this.emailAlternativo = emailAlternativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }
}
