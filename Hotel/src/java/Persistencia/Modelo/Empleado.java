package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class Empleado extends Persona {

	private long cuil;
	private TipoEmpleado tipoEmpleado;

	public Empleado(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public TipoEmpleado getTipoEmpleado(){
		return tipoEmpleado;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTipoEmpleado(TipoEmpleado newVal){
		tipoEmpleado = newVal;
	}

	public long getCuil(){
		return cuil;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCuil(long newVal){
		cuil = newVal;
	}
}//end Empleado