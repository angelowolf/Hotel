package Soporte.EstadoMembresia;

import Persistencia.Modelo.Membresia;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public abstract class EstadoMembresia {

    protected int id;
    private String nombre;

    @Override
    public String toString() {
        return "EstadoMembresia{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    public EstadoMembresia() {
    }

    public void activar(Membresia membresia) {

    }

    public void registrarAviso(Membresia membresia) {

    }

    public void registrarVencimiento(Membresia membresia) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActiva() {
        return false;
    }

    public boolean isPrueba() {
        return false;
    }

    public boolean isVencida() {
        return false;
    }

    public boolean isAviso() {
        return false;
    }
}//end EstadoMembresia
