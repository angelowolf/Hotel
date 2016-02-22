package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.DetalleMantenimiento;
import Persistencia.ORM.DAOInterface.IDetalleMantenimiento;
import Persistencia.ORM.Util.GenericDAO;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class DetalleMantenimientoDAO extends GenericDAO<DetalleMantenimiento, Integer> implements IDetalleMantenimiento {

    @Override
    public void eliminarTodos(int id) {
        Session session = getHibernateTemplate();
        Query query = session.createQuery("delete from DetalleMantenimiento where id_habitacion = :id").setParameter("id", id);
        query.executeUpdate();
    }

}//end DetalleMantenimientoDAO
