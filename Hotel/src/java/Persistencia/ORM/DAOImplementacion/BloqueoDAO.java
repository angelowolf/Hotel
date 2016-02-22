package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Bloqueo;
import Persistencia.ORM.Util.GenericDAO;
import Persistencia.ORM.DAOInterface.IBloqueo;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:20 p.m.
 */
public class BloqueoDAO extends GenericDAO<Bloqueo, Integer> implements IBloqueo {

    @Override
    public void eliminarTodos(int id) {
        Session session = getHibernateTemplate();
        Query query = session.createQuery("delete from Bloqueo where id_habitacion = :id").setParameter("id", id);
        query.executeUpdate();
    }

}//end BloqueoDAO
