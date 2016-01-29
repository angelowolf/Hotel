package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public class Item {

	private int stock;
	private String nombre;

	public Item(){

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

	public int getStock(){
		return stock;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStock(int newVal){
		stock = newVal;
	}
}//end Item