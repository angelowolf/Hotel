package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.TipoHabitacion;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public interface ITipoHabitacion extends IGenericDAO<TipoHabitacion, Integer> {

    /**
     * Busca un Tipo habitacion por nombre.
     *
     * @param nombre
     * @param id el id del hotel al que pertenece el tipo habitacion a buscar
     * @return Tipo habitacion encontrado, o NULL.
     */
    public TipoHabitacion buscar(String nombre, int id);

    /**
     * Verifica si el tipo habitacion está siendo usado por alguna entidad.
     *
     * @param id
     * @return El tipo habitacion si está en uso. NULL si no lo está.
     */
    public Object enUso(int id);

    /**
     * Trae todos los tipo habitacion del hotel
     *
     * @param id el id del hotel.
     * @return Lista de TipoHabitacion
     */
    public List<TipoHabitacion> getTodos(int id);

}
