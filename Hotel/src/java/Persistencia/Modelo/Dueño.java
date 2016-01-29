package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class Dueño extends Persona {

	private Usuario usuario;

	public Dueño(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public Usuario getUsuario(){
		return usuario;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUsuario(Usuario newVal){
		usuario = newVal;
	}
}//end Dueño