package Persistencia.Modelo;

import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoHabitacion {

    private int id;
    private List<Habitacion> habitaciones;
    private String nombre;

    public TipoHabitacion() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    /**
     *
     * @param newVal
     */
    public void setHabitaciones(List<Habitacion> newVal) {
        habitaciones = newVal;
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
}//end TipoHabitacion
