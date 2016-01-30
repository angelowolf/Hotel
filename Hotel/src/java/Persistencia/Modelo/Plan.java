package Persistencia.Modelo;

import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Plan {

    private int id;
    private List<Modulo> modulos;
    private String nombre;
    private int precio;
    private String caracteristica;

    public Plan() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    /**
     *
     * @param newVal
     */
    public void setModulos(List<Modulo> newVal) {
        modulos = newVal;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param newVal
     */
    public void setNombre(String newVal) {
        nombre = newVal;
    }

    public int getPrecio() {
        return precio;
    }

    /**
     *
     * @param newVal
     */
    public void setPrecio(int newVal) {
        precio = newVal;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    /**
     *
     * @param newVal
     */
    public void setCaracteristica(String newVal) {
        caracteristica = newVal;
    }
}//end Plan
