package Persistencia.Modelo;

import java.util.Date;
import java.util.List;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Tarifa {

	private Date fechaDesde;
	private Date fechaHasta;
	private float precio;
	private Temporada temporada;
	private List<TipoHabitacion> tipoHabitaciones;

	public Tarifa(){

	}

	public void finalize() throws Throwable {

	}
	public List<TipoHabitacion> getTipoHabitaciones(){
		return tipoHabitaciones;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTipoHabitaciones(List<TipoHabitacion> newVal){
		tipoHabitaciones = newVal;
	}

	public Temporada getTemporada(){
		return temporada;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTemporada(Temporada newVal){
		temporada = newVal;
	}

	public Date getFechaDesde(){
		return fechaDesde;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaDesde(Date newVal){
		fechaDesde = newVal;
	}

	public Date getFechaHasta(){
		return fechaHasta;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaHasta(Date newVal){
		fechaHasta = newVal;
	}

	public float getPrecio(){
		return precio;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrecio(float newVal){
		precio = newVal;
	}
}//end Tarifa