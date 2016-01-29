package Controlador;

import java.util.List;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public interface IControlador<K> {

	/**
	 * 
	 * @param k
	 */
	public void guardar(K k);

	/**
	 * 
	 * @param k
	 */
	public void actualizar(K k);

	/**
	 * 
	 * @param k
	 */
	public void eliminar(K k);

	/**
	 * 
	 * @param id
	 */
	public int eliminar(int id);

	/**
	 * 
	 * @param id
	 */
	public K getUno(int id);

	public List<K> getTodos();

}