package Persistencia.Modelo;

import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public class Lavado {

    private int id;
    private Date fechaEntrega;
    private Lavanderia lavanderia;
    private DetalleLavado detalleLavado;
    private TipoMovimientoBlanqueria tipoMovimientoBlanqueria;

    public Lavado() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lavanderia getLavanderia() {
        return lavanderia;
    }

    /**
     *
     * @param newVal
     */
    public void setLavanderia(Lavanderia newVal) {
        lavanderia = newVal;
    }

    public DetalleLavado getDetalleLavado() {
        return detalleLavado;
    }

    /**
     *
     * @param newVal
     */
    public void setDetalleLavado(DetalleLavado newVal) {
        detalleLavado = newVal;
    }

    public TipoMovimientoBlanqueria getTipoMovimientoBlanqueria() {
        return tipoMovimientoBlanqueria;
    }

    /**
     *
     * @param newVal
     */
    public void setTipoMovimientoBlanqueria(TipoMovimientoBlanqueria newVal) {
        tipoMovimientoBlanqueria = newVal;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaEntrega(Date newVal) {
        fechaEntrega = newVal;
    }
}//end Lavado
