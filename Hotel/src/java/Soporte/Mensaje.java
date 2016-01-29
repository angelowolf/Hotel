package Soporte;


/**
 * @author angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class Mensaje {

	private static final String modificado = "El %s ha sido modificado con exito.";
	private static final String modificada = "La %s ha sido modificada con exito.";
	private static final String agregado = "El %s ha sido agregado.";
	private static final String agregada = "La %s ha sido agregada.";
	private static final String eliminado = "El %s ha sido eliminado.";
	private static final String eliminada = "La %s ha sido eliminado.";
	private static final String elExiste = "El %s ya existe!";
	private static final String laExiste = "La %s ya existe!";
	private static final String usado = "El %s esta siendo utilizado por alguna %s, debe eliminarla o desvincularlas para poder eliminar este %s!";
	private static final String usada = "La %s esta siendo utilizada por alguna %s, debe eliminarla o desvincularlas para poder eliminar esta %s!";
	private static final String codigoYaEnviado = "Ya se ha enviado un email con el codigo a la direccion ingresada. En %d minutos podra generar otro codigo.";
	private static final String tamañoDisponible = "Actualmente existen %d imagenes, utilizando un espacio de %d MB de 800 MB disponibles.";
	public static final String usuario = "usuario";
	public static final String propiedad = "propiedad";
	public static final String ambiente = "ambiente";
	public static final String servicio = "servicio";
	public static final String contacto = "contacto";
	public static final String propiedadDestacada = "propiedad destacada";
	public static final String tipoMoneda = "tipo moneda";
	public static final String tipoPropiedad = "tipo propiedad";
	public static final String imagenMinimo = "La " + propiedad + " debe contar con una imagen como mínimo.";
	public static final String soloUnaImagen = "La " + propiedadDestacada + " debe contar solo con una imagen.";
	public static final String ingreseNombre = "Ingrese un nombre.";
	public static final String ingreseSimbolo = "Ingrese un simbolo.";
	public static final String ingreseDireccion = "Ingrese una dirección.";
	public static final String ingreseUnCodigo = "Ingrese un codigo.";
	public static final String seleccioneUbicacion = "Seleccione una ubicacion en el mapa.";
	public static final String ingreseUnaImagen = "Ingrese al menos una imagen.";
	public static final String ingreseTitulo = "Ingrese un título.";
	public static final String seleccionePropiedad = "Seleccione una " + propiedad + ".";
	public static final String seleccioneMoneda = "Seleccione un " + tipoMoneda + ".";
	public static final String seleccioneTipoPropiedad = "Seleccione un " + tipoPropiedad + ".";
	public static final String ingreseApellido = "Ingrese un apellido.";
	public static final String ingreseNick = "Ingrese un nick.";
	public static final String ingreseClave = "Ingrese una clave.";
	public static final String ingreseUsuario = "Ingrese el usuario.";
	public static final String ingreseClaveActual = "Ingrese su clave actual.";
	public static final String userClaveIncorrecto = "Usuario o Contraseña incorrectos.";
	public static final String ingreseMail = "Ingrese un email.";
	public static final String errorValidar = "Error al validar el usuario.";
	public static final String codigoCreado = "Se ha enviado un email con el codigo a la direccion ingresada. Verifique en la carpeta de SPAM.";
	public static final String ingreseCodigo = "Ingrese el codigo.";
	public static final String codigoIncorrecto = "El codigo ingresado no es correcto.";
	public static final String ingreseNuevaClave = "Ingrese la nueva clave.";
	public static final String minimoCaracteres = "Mínimo 5 caracteres.";
	public static final String repitaClave = "Repita la clave.";
	public static final String claveNoCoincide = "La clave no coincide.";
	public static final String claveCambiada = "Clave cambiada con exito.";
	public static final String claveIngresadaMal = "Su clave ingresada no es correcta.";
	public static final String codigoEnUso = "El codigo ingresado ya se encuentra en uso.";
	public static final String emailNoEnviado = "Lo sentimos pero su consulta no ha sido enviado.";
	public static final String emailEnviado = "Recibimos tu consulta correctamente.<br>Nos comunicaremos a la brevedad.";
	public static final String ingreseTelefono = "Ingrese un teléfono.";
	public static final String ingreseConsulta = "Ingrese su consulta.";

	public Mensaje(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param archivos
	 * @param size
	 */
	public static String getTamañoDisponible(long archivos, long size){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getCodigoYaEnviado(long arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getModificado(String arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getModificada(String arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getAgregado(String arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getAgregada(String arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getEliminado(String arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getEliminada(String arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getElExiste(String arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 */
	public static String getLaExiste(String arg){
		return "";
	}

	/**
	 * 
	 * @param arg
	 * @param arg2
	 */
	public static String getUsado(String arg, String arg2){
		return "";
	}

	/**
	 * 
	 * @param arg
	 * @param arg2
	 */
	public static String getUsada(String arg, String arg2){
		return "";
	}
}//end Mensaje