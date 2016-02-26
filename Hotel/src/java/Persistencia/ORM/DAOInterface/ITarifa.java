package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Tarifa;
import Persistencia.ORM.Util.IGenericDAO;
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
     * Verifica si la Tarifa está siendo usado por alguna entidad.
     *
     * @param id
     * @return La Tarifa si está en uso. NULL si no lo está.
     */
    public Object enUso(int id);

}
