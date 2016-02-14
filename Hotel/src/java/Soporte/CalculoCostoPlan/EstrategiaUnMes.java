package Soporte.CalculoCostoPlan;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class EstrategiaUnMes extends EstrategiaCalculo {

    /**
     * No aplica ningun descuento.
     *
     * @param totalConRecargo
     * @return el monto sin ningun descuento.
     */
    @Override
    protected int calculoPropio(int totalConRecargo) {
        return totalConRecargo;
    }
}
