package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Provincia {

	private String nombre;

	public Provincia(){

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
}//end Provincia