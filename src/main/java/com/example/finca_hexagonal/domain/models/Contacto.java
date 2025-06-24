package domain.models;

public class Contacto {
    private int id;
    private String email;
    private int telefono;
    private String email_alternativo;

    public Contacto(int id, String email, int telefono, String email_alternativo){
        this.id = id;
        this.email = email;
        this.telefono = telefono;
        this.email_alternativo = email_alternativo;
    }
    public Contacto(){

    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail_alternativo() {
        return email_alternativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail_alternativo(String email_alternativo) {
        this.email_alternativo = email_alternativo;
    }
}
