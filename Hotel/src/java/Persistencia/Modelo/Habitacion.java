package Persistencia.Modelo;

import java.util.List;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class Habitacion {

	private String nombre;
	private TipoHabitacion tipoHabitacion;
	private List<DetalleMantenimiento> mantenimiento;
	private int capacidad;
	private List<Bloqueo> bloqueos;

	public Habitacion(){

	}

	public void finalize() throws Throwable {

	}
	public List<Bloqueo> getBloqueos(){
		return bloqueos;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBloqueos(List<Bloqueo> newVal){
		bloqueos = newVal;
	}

	public List<DetalleMantenimiento> getMantenimiento(){
		return mantenimiento;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMantenimiento(List<DetalleMantenimiento> newVal){
		mantenimiento = newVal;
	}

	public TipoHabitacion getTipoHabitacion(){
		return tipoHabitacion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTipoHabitacion(TipoHabitacion newVal){
		tipoHabitacion = newVal;
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

	public int getCapacidad(){
		return capacidad;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCapacidad(int newVal){
		capacidad = newVal;
	}
}//end Habitacion