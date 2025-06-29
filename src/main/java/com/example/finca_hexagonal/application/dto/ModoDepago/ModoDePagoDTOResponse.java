package com.example.finca_hexagonal.application.dto.ModoDepago;

public class ModoDePagoDTOResponse {

    private Long id;
    private Long pago_id;
    private String tipo;
    private String detalles;

    public ModoDePagoDTOResponse(){

    }

    public ModoDePagoDTOResponse(String detalles, String tipo, Long pago_id, Long id) {
        this.detalles = detalles;
        this.tipo = tipo;
        this.pago_id = pago_id;
        this.id = id;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getPago_id() {
        return pago_id;
    }

    public void setPago_id(Long pago_id) {
        this.pago_id = pago_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
