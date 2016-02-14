package Soporte.CalculoCostoPlan;

import Persistencia.Modelo.Plan;
import Persistencia.Modelo.TipoPago;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public abstract class EstrategiaCalculo {

    /**
     * Calcula el costro del plan segun el tipo de pago seleccionado y el
     * descuento segun los meses que selecciono.
     *
     * @param tipoPago
     * @param plan
     * @return El costo del plan.
     */
    public int calcularPrecioPlan(TipoPago tipoPago, Plan plan) {
        int recargo = 0;
        if (!tipoPago.isContado()) {
            recargo = (int) (plan.getPrecio() / tipoPago.getPorcentajeRecargo());
        }
        return calculoPropio(recargo + plan.getPrecio());
    }

    protected abstract int calculoPropio(int totalConRecargo);
}
