package domain.models;

public class Usuario {
    private int id;
    private String email;
    private String nombre_usuario;
    private String contraseña;
    private String cuenta_activa;

    public Usuario(int id, String email, String nombre_usuario, String contraseña, String cuenta_activa){
        this.id = id;
        this.email = email;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.cuenta_activa = cuenta_activa;
    }

    public Usuario(){

    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCuenta_activa() {
        return cuenta_activa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCuenta_activa(String cuenta_activa) {
        this.cuenta_activa = cuenta_activa;
    }
}
