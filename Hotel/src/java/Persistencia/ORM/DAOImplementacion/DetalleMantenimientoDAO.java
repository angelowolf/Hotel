package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.DetalleMantenimiento;
import Persistencia.ORM.DAOInterface.IDetalleMantenimiento;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<DetalleMantenimiento> getTodos(int id_habitacion) {
        Session session = getHibernateTemplate();
        List<DetalleMantenimiento> objetos = new ArrayList<DetalleMantenimiento>();
        try {
            objetos = session.createQuery("from DetalleMantenimiento where id_habitacion = :id").setParameter("id", id_habitacion).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}//end DetalleMantenimientoDAO
