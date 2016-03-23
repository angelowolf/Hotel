package Persistencia.Modelo;

import java.util.Date;
import java.util.Set;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Tarifa {

    private int id;
    private Date fechaInicio;
    private Date fechaFin;
    private float precio;
    private Temporada temporada;
    private Set<TipoHabitacion> tipoHabitaciones;

    public Tarifa() {
        temporada = new Temporada();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<TipoHabitacion> getTipoHabitaciones() {
        return tipoHabitaciones;
    }

    /**
     *
     * @param newVal
     */
    public void setTipoHabitaciones(Set<TipoHabitacion> newVal) {
        tipoHabitaciones = newVal;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    /**
     *
     * @param newVal
     */
    public void setTemporada(Temporada newVal) {
        temporada = newVal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaInicio(Date newVal) {
        fechaInicio = newVal;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaFin(Date newVal) {
        fechaFin = newVal;
    }

    public float getPrecio() {
        return precio;
    }

    /**
     *
     * @param newVal
     */
    public void setPrecio(float newVal) {
        precio = newVal;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", precio=" + precio + ", temporada=" + temporada + ", tipoHabitaciones=" + tipoHabitaciones + '}';
    }

}//end Tarifa
