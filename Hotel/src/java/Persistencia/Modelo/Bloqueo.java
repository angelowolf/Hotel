package Persistencia.Modelo;

import java.util.Date;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:20 p.m.
 */
public class Bloqueo {

	private Date fechaInicio;
	private Date fechaFIn;

	public Bloqueo(){

	}

	public void finalize() throws Throwable {

	}
	public Date getFechaInicio(){
		return fechaInicio;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaInicio(Date newVal){
		fechaInicio = newVal;
	}

	public Date getFechaFIn(){
		return fechaFIn;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaFIn(Date newVal){
		fechaFIn = newVal;
	}
}//end Bloqueo