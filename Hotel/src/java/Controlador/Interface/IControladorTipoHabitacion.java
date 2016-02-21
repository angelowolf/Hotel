/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.TipoHabitacion;
import Persistencia.ORM.DAOImplementacion.HotelDAO;
import Persistencia.ORM.DAOImplementacion.TipoHabitacionDAO;
import Persistencia.ORM.DAOInterface.IHotel;
import Persistencia.ORM.DAOInterface.ITipoHabitacion;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorTipoHabitacion {

    final ITipoHabitacion TIPOHABITACIONDAO = new TipoHabitacionDAO();
    final IHotel HOTELDAO = new HotelDAO();

    /**
     * Crea un nuevo tipo de habitacion para el hotel.
     *
     * @param nombre El nombre del tipo de habitacion.
     * @param hotel El hotel al que se le guardara.
     */
    public void guardar(String nombre, Hotel hotel);

    /**
     * Actualiza los datos de un tipo de habitacion.
     *
     * @param id
     * @param nombre
     */
    public void actualizar(int id, String nombre);

    /**
     * Elimina un tipo de habitacion.
     *
     * @param id
     */
    public void eliminar(int id);

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el
     * del propio tipo de habitacion devolvera true.
     *
     * @param id
     * @param nombre
     * @param hotel
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre, Hotel hotel);

    /**
     * verifica si el tipo de habitacion esta asociado a alguna habitacion.
     *
     * @param id
     * @return true si lo esta.
     */
    public boolean enUso(int id);

    /**
     * Busca todos los tipos de habitacion existentes del hotel.
     *
     * @param hotel El hotel al que se le buscaran los tipos de habitacion,
     * @return Los tipos de habitaciones.
     */
    public List<TipoHabitacion> getTodos(Hotel hotel);

    /**
     * recupera un tipo de habitacion de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    public TipoHabitacion getUno(int id);

}
