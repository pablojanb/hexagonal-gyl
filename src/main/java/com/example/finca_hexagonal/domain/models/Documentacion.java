package domain.models;

public class Documentacion {
    private int id;
    private int propietario_id;
    private String escritura_propiedad;
    private String plano_catastral;
    private String impuesto_bienesInmuebles;

    public Documentacion(int id, int propietario_id, String escritura_propiedad, String plano_catastral, String impuesto_bienesInmuebles){
        this.id = id;
        this.propietario_id = propietario_id;
        this.escritura_propiedad = escritura_propiedad;
        this.plano_catastral = plano_catastral;
        this.impuesto_bienesInmuebles = impuesto_bienesInmuebles;

    }

    public Documentacion(){

    }

    public int getId() {
        return id;
    }

    public int getPropietario_id() {
        return propietario_id;
    }

    public String getEscritura_propiedad() {
        return escritura_propiedad;
    }

    public String getPlano_catastral() {
        return plano_catastral;
    }

    public String getImpuesto_bienesInmuebles() {
        return impuesto_bienesInmuebles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPropietario_id(int propietario_id) {
        this.propietario_id = propietario_id;
    }

    public void setEscritura_propiedad(String escritura_propiedad) {
        this.escritura_propiedad = escritura_propiedad;
    }

    public void setPlano_catastral(String plano_catastral) {
        this.plano_catastral = plano_catastral;
    }

    public void setImpuesto_bienesInmuebles(String impuesto_bienesInmuebles) {
        this.impuesto_bienesInmuebles = impuesto_bienesInmuebles;
    }
}
