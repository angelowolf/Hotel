package Persistencia.Modelo;

import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class Habitacion {

    private int id;
    private String nombre;
    private List<DetalleMantenimiento> mantenimientos;
    private int capacidad;
    private List<Bloqueo> bloqueos;

    public Habitacion() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Bloqueo> getBloqueos() {
        return bloqueos;
    }

    /**
     *
     * @param newVal
     */
    public void setBloqueos(List<Bloqueo> newVal) {
        bloqueos = newVal;
    }

    public List<DetalleMantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    /**
     *
     * @param newVal
     */
    public void setMantenimientos(List<DetalleMantenimiento> newVal) {
        mantenimientos = newVal;
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

    public int getCapacidad() {
        return capacidad;
    }

    /**
     *
     * @param newVal
     */
    public void setCapacidad(int newVal) {
        capacidad = newVal;
    }
}//end Habitacion
