package Persistencia.Modelo;

import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Tarifa {

    private int id;
    private Date fecha;
    private float precio;
    private TipoHabitacion tipoHabitacion;
    private int capacidad;

    public Tarifa() {
        tipoHabitacion = new TipoHabitacion();
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "id=" + id + ", fecha=" + fecha + ", precio=" + precio + ", tipoHabitacion=" + tipoHabitacion + ", capacidad=" + capacidad + '}';
    }

}//end Tarifa
