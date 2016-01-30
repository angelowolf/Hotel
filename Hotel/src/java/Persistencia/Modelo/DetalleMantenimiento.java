package Persistencia.Modelo;

import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class DetalleMantenimiento {

    private int id;
    private String descripcion;
    private Date fecha;
    private boolean resuelto;

    public DetalleMantenimiento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param newVal
     */
    public void setDescripcion(String newVal) {
        descripcion = newVal;
    }

    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param newVal
     */
    public void setFecha(Date newVal) {
        fecha = newVal;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    /**
     *
     * @param newVal
     */
    public void setResuelto(boolean newVal) {
        resuelto = newVal;
    }
}//end DetalleMantenimiento
