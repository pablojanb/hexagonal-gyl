package domain.models;

public class rol_permiso {
    private int id;
    private int rol_id;

    public rol_permiso(int id, int rol_id){
        this.id = rol_id;
        this.rol_id = rol_id;

    }

    public rol_permiso(){

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
