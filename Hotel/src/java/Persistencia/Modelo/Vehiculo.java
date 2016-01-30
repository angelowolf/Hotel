package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class Vehiculo {

    private int id;
    private String color;
    private String modelo;
    private String patente;

    public Vehiculo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    /**
     *
     * @param newVal
     */
    public void setPatente(String newVal) {
        patente = newVal;
    }

    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param newVal
     */
    public void setModelo(String newVal) {
        modelo = newVal;
    }

    public String getColor() {
        return color;
    }

    /**
     *
     * @param newVal
     */
    public void setColor(String newVal) {
        color = newVal;
    }
}//end Vehiculo
