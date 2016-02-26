/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.Temporada;
import Persistencia.ORM.DAOImplementacion.TemporadaDAO;
import Persistencia.ORM.DAOInterface.ITemporada;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorTemporada {

    final ITemporada TEMPORADADAO = new TemporadaDAO();

    /**
     * Crea una nueva temporada.
     *
     * @param nombre
     * @param fechaInicio
     * @param fechaFin
     * @param id_hotel
     * @throws java.text.ParseException Si la fecha no tiene el formato correcto
     * dd-mm-yy
     */
    public void guardar(String nombre, String fechaInicio, String fechaFin, int id_hotel) throws ParseException;

    /**
     * Actualiza los datos de una temporada. El id_hotel es utilizado para
     * cuestiones de validaciones, que solo puedan ser modificadas objetos
     * propios del hotel.
     *
     * @param id
     * @param nombre
     * @param fechaInicio
     * @param fechaFin
     * @param id_hotel
     * @throws java.text.ParseException Si la fecha no tiene el formato correcto
     * dd-mm-yy
     * @throws IllegalAccessError Si se accede a algun objeto que no pertenezca
     * el hotel
     */
    public void actualizar(int id, String nombre, String fechaInicio, String fechaFin, int id_hotel) throws ParseException, IllegalAccessError;

    /**
     * Elimina una temporada. El id_hotel es utilizado para cuestiones de
     * validaciones, que solo puedan ser eliminados objetos propios del hotel.
     *
     * @param id
     * @param id_hotel
     * @return True si se elimino. Falso si esta siendo utilizado por otra
     * entidad.
     * @throws IllegalAccessError Si se accede a algun objeto que no pertenezca
     * el hotel
     */
    public boolean eliminar(int id, int id_hotel) throws IllegalAccessError;

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el de
     * la propia temporada devolvera true.
     *
     * @param id
     * @param nombre
     * @param id_hotel
     *
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre, int id_hotel);

    /**
     * verifica si la temporada esta asociado a alguna entidad.
     *
     * @param id
     * @return true si lo esta.
     */
    public boolean enUso(int id);

    /**
     * trae todos las temporadas de un hotel.
     *
     * @param id_hotel
     * @return
     */
    public List<Temporada> getTodos(int id_hotel);

    /**
     * recupera una temporada de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    public Temporada getUno(int id);

}
