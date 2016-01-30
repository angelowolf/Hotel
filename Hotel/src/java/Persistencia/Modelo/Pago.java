package Persistencia.Modelo;

import Soporte.CalculoCostoPlan.EstrategiaCalculo;
import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class Pago {

    private int id;
    private EstadoPago estadoPago;
    private Date fechaPago;
    private TipoPago tipoPago;
    private int total;
    private EstrategiaCalculo estrategiaCalculo;

    public Pago() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstrategiaCalculo getEstrategiaCalculo() {
        return estrategiaCalculo;
    }

    public void setEstrategiaCalculo(EstrategiaCalculo estrategiaCalculo) {
        this.estrategiaCalculo = estrategiaCalculo;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    /**
     *
     * @param newVal
     */
    public void setTipoPago(TipoPago newVal) {
        tipoPago = newVal;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    /**
     *
     * @param newVal
     */
    public void setEstadoPago(EstadoPago newVal) {
        estadoPago = newVal;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaPago(Date newVal) {
        fechaPago = newVal;
    }

    public int getTotal() {
        return total;
    }

    /**
     *
     * @param newVal
     */
    public void setTotal(int newVal) {
        total = newVal;
    }

    /**
     *
     * @param plan
     */
    public int calcularCosto(Plan plan) {
        return 0;
    }
}//end Pago
