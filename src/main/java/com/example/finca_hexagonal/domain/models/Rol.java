package domain.models;

public class Rol {
    private int id;
    private String nombre;

    public Rol(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Rol(){

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
