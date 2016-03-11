/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.Habitacion;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.ORM.DAOImplementacion.HabitacionDAO;
import Persistencia.ORM.DAOImplementacion.TipoHabitacionDAO;
import Persistencia.ORM.DAOInterface.IHabitacion;
import Persistencia.ORM.DAOInterface.ITipoHabitacion;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorHabitacion {

    final ITipoHabitacion TIPOHABITACIONDAO = new TipoHabitacionDAO();
    final IHabitacion HABITACIONDAO = new HabitacionDAO();

    /**
     * Crea una nueva habitacion. El tipo de habitacion es unico por cada hotel.
     *
     * @param nombre El nombre del tipo de habitacion.
     * @param capacidad la capacidad
     * @param id_tipohabitacion
     *
     */
    public void guardar(String nombre, int capacidad, int id_tipohabitacion);

    /**
     * Actualiza los datos de una habitacion. El id_hotel es utilizado para
     * cuestiones de validaciones, que solo puedan ser modificadas objetos
     * propios del hotel.
     *
     * @param id
     * @param nombre
     * @param capacidad
     * @param id_tipohabitacion
     * @param id_hotel
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public void actualizar(int id, String nombre, int capacidad, int id_tipohabitacion, int id_hotel) throws AccesoIlegal,ObjetoNoEncontrado;

    /**
     * Actualiza el tipo de habitacion. El id_hotel es utilizado para cuestiones
     * de validaciones, que solo puedan ser modificadas objetos propios del
     * hotel
     *
     * @param id
     * @param id_tipohabitacion
     * @param id_hotel
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public void actualizar(int id, int id_tipohabitacion, int id_hotel) throws AccesoIlegal,ObjetoNoEncontrado;

    /**
     * Elimina una habitacion. El id_hotel es utilizado para cuestiones de
     * validaciones, que solo puedan ser eliminados objetos propios del hotel.
     *
     * @param id
     * @param id_hotel
     * @return True si se elimino. Falso si esta siendo utilizado por otra
     * entidad.
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public boolean eliminar(int id, int id_hotel) throws AccesoIlegal,ObjetoNoEncontrado;

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el de
     * la propia habitacion devolvera true.
     *
     * @param id
     * @param nombre
     * @param id_hotel
     *
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre, int id_hotel);

    /**
     * verifica si la habitacion esta asociado a alguna entidad.
     *
     * @param id
     * @return true si lo esta.
     */
    public boolean enUso(int id);

    /**
     * Busca todos las habitaciones existentes del hotel.
     *
     * @param id_hotel El hotel al que se le buscaran las habitaciones,
     * @return Las habitaciones
     */
    public List<Habitacion> getTodos(int id_hotel);

    /**
     * recupera una habitacion de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @param id_hotel
     * @return el objeto o nulo.
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public Habitacion getUno(int id,int id_hotel)throws AccesoIlegal,ObjetoNoEncontrado;

    /**
     * Busca todas las habitaciones segun el tipo de habitacion solicitado. El
     * id_hotel es utilizado para cuestiones de validaciones, que solo puedan
     * ser eliminados objetos propios del hotel.
     *
     * @param id_tipoHabitacion
     * @param id_hotel
     * @throws Persistencia.Modelo.AccesoIlegal
     * @return
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public List<Habitacion> getHabitacionesByTipoHabitacion(int id_tipoHabitacion, int id_hotel) throws AccesoIlegal,ObjetoNoEncontrado;

}
