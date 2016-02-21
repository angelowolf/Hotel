package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Hotel;
import Persistencia.ORM.Util.IGenericDAO;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:26 p.m.
 */
public interface IHotel extends IGenericDAO<Hotel, Integer> {

    /**
     * Devuelve el hotel al que pertenece este usuario.
     *
     * @param id Id del usuario.
     * @return Hotel.
     */
    public Hotel getHotelByUsuario(int id);

}
