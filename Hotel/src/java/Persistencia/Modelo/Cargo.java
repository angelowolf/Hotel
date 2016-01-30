package Persistencia.Modelo;

import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:20 p.m.
 */
public class Cargo {

    private int id;
    private Date fecha;
    private float monto;
    private String descripcion;
    private TipoCargo tipoCargo;

    public Cargo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }

    /**
     *
     * @param newVal
     */
    public void setTipoCargo(TipoCargo newVal) {
        tipoCargo = newVal;
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

    public float getMonto() {
        return monto;
    }

    /**
     *
     * @param newVal
     */
    public void setMonto(float newVal) {
        monto = newVal;
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
}//end Cargo
