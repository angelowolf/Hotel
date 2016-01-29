package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoPago {

	private String nombre;
	private float porcentajeRecargo;

	public TipoPago(){

	}

	public void finalize() throws Throwable {

	}
	public String getNombre(){
		return nombre;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombre(String newVal){
		nombre = newVal;
	}

	public float getPorcentajeRecargo(){
		return porcentajeRecargo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPorcentajeRecargo(float newVal){
		porcentajeRecargo = newVal;
	}
}//end TipoPago