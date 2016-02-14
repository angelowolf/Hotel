package Persistencia.Modelo;

import Soporte.EstadoMembresia.EstadoMembresia;
import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class Membresia {

    private int id;
    private EstadoMembresia estadoMembresia;
    private Date fechaActivacion;
    private Date fechaVencimiento;
    private Date fechaAviso;


    public EstadoMembresia getEstadoMembresia() {
        return estadoMembresia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param newVal
     */
    public void setEstadoMembresia(EstadoMembresia newVal) {
        estadoMembresia = newVal;
    }

    public Date getFechaAviso() {
        return fechaAviso;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaAviso(Date newVal) {
        fechaAviso = newVal;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaVencimiento(Date newVal) {
        fechaVencimiento = newVal;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaActivacion(Date newVal) {
        fechaActivacion = newVal;
    }

    public boolean isActiva() {
        return this.estadoMembresia.isActiva();
    }

    public boolean isVencida() {
        return this.estadoMembresia.isVencida();
    }

    public boolean isAviso() {
        return this.estadoMembresia.isAviso();
    }

    @Override
    public String toString() {
        return "Membresia{" + "id=" + id + ", estadoMembresia=" + estadoMembresia + ", fechaActivacion=" + fechaActivacion + ", fechaVencimiento=" + fechaVencimiento + ", fechaAviso=" + fechaAviso + '}';
    }

}//end Membresia
