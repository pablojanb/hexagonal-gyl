package application.domain.models;

public class Usuario_rol {
    private int id;
    private int rol_id;

    public Usuario_rol(int id, int rol_id){
        this.id = id;
        this.rol_id = rol_id;
    }

    public Usuario_rol(){

    }

    public int getId() {
        return id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }
}
