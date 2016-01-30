package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class Domicilio {

    private int id;
    private String torre;
    private String calle;
    private int numero;
    private String departamento;
    private int piso;
    private Localidad localidad;

    public Domicilio() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     *
     * @param newVal
     */
    public void setLocalidad(Localidad newVal) {
        localidad = newVal;
    }

    public int getPiso() {
        return piso;
    }

    /**
     *
     * @param newVal
     */
    public void setPiso(int newVal) {
        piso = newVal;
    }

    public String getDepartamento() {
        return departamento;
    }

    /**
     *
     * @param newVal
     */
    public void setDepartamento(String newVal) {
        departamento = newVal;
    }

    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param newVal
     */
    public void setNumero(int newVal) {
        numero = newVal;
    }

    public String getCalle() {
        return calle;
    }

    /**
     *
     * @param newVal
     */
    public void setCalle(String newVal) {
        calle = newVal;
    }

    public String getTorre() {
        return torre;
    }

    /**
     *
     * @param newVal
     */
    public void setTorre(String newVal) {
        torre = newVal;
    }
}//end Domicilio
