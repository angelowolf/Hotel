package Controlador;

import Persistencia.Modelo.TipoUsuario;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTipoUsuario implements IControlador<TipoUsuario> {

	public ControladorTipoUsuario(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param k
	 */
	public void guardar(TipoUsuario k){

	}

	/**
	 * 
	 * @param k
	 */
	public void actualizar(TipoUsuario k){

	}

	/**
	 * 
	 * @param k
	 */
	public void eliminar(TipoUsuario k){

	}

	/**
	 * 
	 * @param id
	 */
	public int eliminar(int id){
		return 0;
	}

	/**
	 * 
	 * @param id
	 */
	public TipoUsuario getUno(int id){
		return null;
	}

	public List<TipoUsuario> getTodos(){
		return null;
	}

    TipoUsuario getTipoUsuarioOwner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//end ControladorTipoUsuario