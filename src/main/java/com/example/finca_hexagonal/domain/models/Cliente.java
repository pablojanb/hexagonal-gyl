package com.example.finca_hexagonal.domain.models;

public class Cliente {
    private int id;
    private int usuario_id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;


    public Cliente(){

    }

    public Cliente(int id, int usuario_id, String nombre, String apellido, String dni, String correo){
        this.id = id;
        this.usuario_id = usuario_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
