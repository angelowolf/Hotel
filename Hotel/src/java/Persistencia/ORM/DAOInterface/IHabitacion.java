package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Habitacion;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:26 p.m.
 */
public interface IHabitacion extends IGenericDAO<Habitacion, Integer> {

    /**
     * Busca una habitacion por nombre.
     *
     * @param nombre
     * @param id el id del hotel al que pertenecela habitacion a buscar.
     * @return Habitacion encontrado, o NULL.
     */
    public Habitacion buscar(String nombre, int id);

    /**
     * Verifica si la habitacion está siendo usado por alguna entidad.
     *
     * @param id
     * @return La habitacion si está en uso. NULL si no lo está.
     */
    public Object enUso(int id);

    /**
     * Trae todos las habitaciones del hotel.
     *
     * @param id el id del hotel.
     * @return Lista de TipoHabitacion
     */
    public List<Habitacion> getTodos(int id);

    /**
     * Trae todas las habitaciones segun un tipo de habitacion.
     *
     * @param id_tipoHabitacion
     * @return
     */
    public List<Habitacion> getTodosByTipoHabitacion(int id_tipoHabitacion);

}
