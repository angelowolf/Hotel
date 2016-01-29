package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class Usuario {

	private String clave;
	private String email;
	private String nick;
	private TipoUsuario tipoUsuario;

	public Usuario(){

	}

	public void finalize() throws Throwable {

	}
	public TipoUsuario getTipoUsuario(){
		return tipoUsuario;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTipoUsuario(TipoUsuario newVal){
		tipoUsuario = newVal;
	}

	public String getNick(){
		return nick;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNick(String newVal){
		nick = newVal;
	}

	public String getEmail(){
		return email;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmail(String newVal){
		email = newVal;
	}

	public String getClave(){
		return clave;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setClave(String newVal){
		clave = newVal;
	}
}//end Usuario