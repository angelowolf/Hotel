package Soporte;

import java.io.File;


/**
 * @author angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:20 p.m.
 */
public class Archivo {

	public Archivo(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * Renombra una carpeta o un archivo.
	 * 
	 * @param rutaOriginal    Nombre original.
	 * @param rutaNueva    Nuevo nombre.
	 */
	public static void renombrarCarpeta(String rutaOriginal, String rutaNueva){

	}

	/**
	 * Crea un archivo en el disco del sistema, y devuelve la ruta del archivo para
	 * poder ser guardaro en la base de datos.
	 * @return La ruta para la BD.
	 * 
	 * @param ruta    La ruta del archivo donde sera creado.
	 * @param upload    EL archivo.
	 * @param uploadFileName    El nombre del archivo.
	 */
	public static String crearImagen(String ruta, File upload, String uploadFileName){
		return "";
	}

	/**
	 * Elimina todos los archivos que contenga una carpeta, o el archivo en si.
	 * 
	 * @param ruta    La ruta de una carpeta o un archivo.
	 */
	public static void delete(String ruta){

	}

	/**
	 * Elimina todos los archivos que contenga una carpeta, o el archivo en si.
	 * 
	 * @param file    Una carpeta o un archivo.
	 */
	public static void delete(File file){

	}
}//end Archivo