package com.example.finca_hexagonal.domain.models;


public class AutenticacionExterna {
    private int id;
    private String nombreProveedor;
    private int proveedor_usuario_id;
    private int usuario_id;

    public AutenticacionExterna(int id, String nombreProveedor, int proveedor_usuario_id, int usuario_id){
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.proveedor_usuario_id = proveedor_usuario_id;
        this.usuario_id = usuario_id;
    }

    public int getId() {
        return id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public int getProveedor_usuario_id() {
        return proveedor_usuario_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setProveedor_usuario_id(int proveedor_usuario_id) {
        this.proveedor_usuario_id = proveedor_usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
