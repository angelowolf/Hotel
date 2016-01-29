package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoCobro {

	private String nombre;

	public TipoCobro(){

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
}//end TipoCobro