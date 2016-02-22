package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Bloqueo;
import Persistencia.ORM.Util.IGenericDAO;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public interface IBloqueo extends IGenericDAO<Bloqueo, Integer> {

    /**
     * Elimina todos los bloqueos de la habitacion solicitada.
     *
     * @param id La habitacion
     */
    public void eliminarTodos(int id);

}
