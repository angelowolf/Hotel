package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Habitacion;
import Persistencia.Modelo.Tarifa;
import Persistencia.Modelo.TipoHabitacion;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.Date;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public interface ITarifa extends IGenericDAO<Tarifa, Integer> {

    /**
     * Trae todos las Tarifa del hotel.
     *
     * @param id_hotel el id del hotel.
     * @return Lista de Temporada
     */
    public List<Tarifa> getTodos(int id_hotel);

    /**
     * Busca una tarifa para esa habitacion en esa fecha,si la encuentra es
     * devuelta sino null.
     *
     * @param th
     * @param capacidad
     * @param fecha
     * @return Tarifa o Null.
     */
    public Tarifa getUno(TipoHabitacion th, Date fecha, Integer capacidad);

}
