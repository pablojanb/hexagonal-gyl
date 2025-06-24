package domain.models;

import java.util.Date;

public class Propietario {
    private int id;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private int contacto_id;
    private int usuario_id;

    public Propietario(int id, String nombre, String apellido, Date fechaNac, int contacto_id, int usuario_id){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.contacto_id = contacto_id;
        this.usuario_id = usuario_id;

    }

    public Propietario(){

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public int getContacto_id() {
        return contacto_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setContacto_id(int contacto_id) {
        this.contacto_id = contacto_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
