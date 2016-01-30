package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class Particular extends Persona implements ICliente {
  
	private Vehiculo vehiculo;
	public Vehiculo m_Vehiculo;

	public Particular(){

	}

	public Vehiculo getVehiculo(){
		return vehiculo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVehiculo(Vehiculo newVal){
		vehiculo = newVal;
	}
}//end Particular