package Persistencia.Modelo;

import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:20 p.m.
 */
public class Bloqueo {

    private int id, id_habitacion;
    private Date fechaInicio;
    private Date fechaFIn;

    public Bloqueo() {

    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFechaFIn() {
        return fechaFIn;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaFIn(Date newVal) {
        fechaFIn = newVal;
    }
}//end Bloqueo
