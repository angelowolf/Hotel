package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class Localidad {

	private int codigoPostal;
	private String nombre;
	private Provincia provincia;

	public Localidad(){

	}

	public void finalize() throws Throwable {

	}
	public Provincia getProvincia(){
		return provincia;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProvincia(Provincia newVal){
		provincia = newVal;
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

	public int getCodigoPostal(){
		return codigoPostal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigoPostal(int newVal){
		codigoPostal = newVal;
	}
}//end Localidad