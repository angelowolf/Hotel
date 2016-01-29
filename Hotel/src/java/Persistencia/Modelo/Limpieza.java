package Persistencia.Modelo;

import java.util.Date;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public class Limpieza {

    private Date fechaDesde;
    private Date fechaHasta;
    private List<Habitacion> habitaciones;
    private Empleado empleado;
    public List<Habitacion> habitacion;

    public Limpieza() {

    }

    public void finalize() throws Throwable {

    }

    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     *
     * @param newVal
     */
    public void setEmpleado(Empleado newVal) {
        empleado = newVal;
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

    public Date getFechaHasta() {
        return fechaHasta;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaHasta(Date newVal) {
        fechaHasta = newVal;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaDesde(Date newVal) {
        fechaDesde = newVal;
    }
}//end Limpieza
