package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.TipoUsuario;
import Persistencia.ORM.Util.IGenericDAO;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public interface ITipoUsuario extends IGenericDAO<TipoUsuario, Integer> {

    /**
     * Devuelve un objeto TipoUsuario del tipo "OWNER"
     *
     * @return TipoUsuario
     */
    public TipoUsuario getTipoOwner();
}
