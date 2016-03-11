/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.ObjetoNoEncontrado;
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
     * @param id_hotel El hotel.
     *
     */
    public void guardar(String nombre, int id_hotel);

    /**
     * Actualiza los datos de un tipo de habitacion. El id_hotel es utilizado
     * para cuestiones de validaciones, que solo puedan ser modificadas objetos
     * propios del hotel.
     *
     * @param id
     * @param nombre
     * @param id_hotel
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public void actualizar(int id, String nombre, int id_hotel) throws AccesoIlegal, ObjetoNoEncontrado;

    /**
     * Elimina un tipo de habitacion. El id_hotel es utilizado para cuestiones
     * de validaciones, que solo puedan ser eliminados objetos propios del
     * hotel.
     *
     * @param id
     * @param id_hotel
     * @return True si se elimino. False si esta siendo utilizado por otra
     * entidad.
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public boolean eliminar(int id, int id_hotel) throws AccesoIlegal, ObjetoNoEncontrado;

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el
     * del propio tipo de habitacion devolvera true.
     *
     * @param id
     * @param nombre
     * @param id_hotel
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre, int id_hotel);

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
     * @param id_hotel El hotel al que se le buscaran los tipos de habitacion,
     * @return Los tipos de habitaciones.
     */
    public List<TipoHabitacion> getTodos(int id_hotel);

    /**
     * recupera un tipo de habitacion de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @param id_hotel
     * @return el objeto o nulo.
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public TipoHabitacion getUno(int id, int id_hotel) throws AccesoIlegal, ObjetoNoEncontrado;

}
