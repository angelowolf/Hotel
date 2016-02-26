package Persistencia.Modelo;

import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Temporada {

    private int id, id_hotel;
    private Date fechaFin;
    private Date fechaInicio;
    private String nombre;

    public Temporada() {

    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
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
}//end Temporada
