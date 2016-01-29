package Persistencia.Modelo;

import java.util.Date;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:20 p.m.
 */
public class Cobro {

	private String descripcion;
	private Date fechaCobro;
	private MedioCobro medioCobro;
	private float monto;
	private TipoCobro tipoCobro;

	public Cobro(){

	}

	public void finalize() throws Throwable {

	}
	public MedioCobro getMedioCobro(){
		return medioCobro;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMedioCobro(MedioCobro newVal){
		medioCobro = newVal;
	}

	public TipoCobro getTipoCobro(){
		return tipoCobro;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTipoCobro(TipoCobro newVal){
		tipoCobro = newVal;
	}

	public String getDescripcion(){
		return descripcion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescripcion(String newVal){
		descripcion = newVal;
	}

	public Date getFechaCobro(){
		return fechaCobro;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaCobro(Date newVal){
		fechaCobro = newVal;
	}

	public float getMonto(){
		return monto;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMonto(float newVal){
		monto = newVal;
	}
}//end Cobro