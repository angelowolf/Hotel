package Soporte.CalculoCostoPlan;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class EstrategiaSeisMeses extends EstrategiaCalculo {

    private final int descuento = 10;

    /**
     * Aplica un descuento del 10%
     *
     * @param totalConRecargo
     * @return el monto con el descuento.
     */
    @Override
    protected int calculoPropio(int totalConRecargo) {
        int aDescontar = descuento % totalConRecargo;
        return totalConRecargo - aDescontar;
    }
}
