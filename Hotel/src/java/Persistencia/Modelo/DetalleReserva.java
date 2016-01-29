package Persistencia.Modelo;

import java.util.Date;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class DetalleReserva {

	private Date fechaIngreso;
	private Date fechaSalida;
	private Habitacion habitacion;
	private int adultos;
	private int menores;

	public DetalleReserva(){

	}

	public void finalize() throws Throwable {

	}
	public Habitacion getHabitacion(){
		return habitacion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHabitacion(Habitacion newVal){
		habitacion = newVal;
	}

	public Date getFechaIngreso(){
		return fechaIngreso;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaIngreso(Date newVal){
		fechaIngreso = newVal;
	}

	public Date getFfechaSalida(){
		return fechaSalida;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFfechaSalida(Date newVal){
		fechaSalida = newVal;
	}

	public int getAdultos(){
		return adultos;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdultos(int newVal){
		adultos = newVal;
	}

	public int getMenores(){
		return menores;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMenores(int newVal){
		menores = newVal;
	}
}//end DetalleReserva