package Soporte.CalculoCostoPlan;

import Persistencia.Modelo.Plan;
import Persistencia.Modelo.TipoPago;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public abstract class EstrategiaCalculo {

	public EstrategiaCalculo(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param tipoPago
	 * @param plan
	 */
	public int calcularPrecioPlan(TipoPago tipoPago, Plan plan){
		return 0;
	}

	/**
	 * 
	 * @param totalConRecargo
	 */
	protected abstract int calculoPropio(int totalConRecargo);
}//end EstrategiaCalculo