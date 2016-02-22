package Persistencia.Modelo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class Habitacion {

    private int id;
    private String nombre;
    private Set<DetalleMantenimiento> mantenimientos = new HashSet<DetalleMantenimiento>();
    private int capacidad;
    private Set<Bloqueo> bloqueos = new HashSet<Bloqueo>();
    private TipoHabitacion tipoHabitacion;

    public Habitacion() {

    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<DetalleMantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(Set<DetalleMantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public Set<Bloqueo> getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(Set<Bloqueo> bloqueos) {
        this.bloqueos = bloqueos;
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
