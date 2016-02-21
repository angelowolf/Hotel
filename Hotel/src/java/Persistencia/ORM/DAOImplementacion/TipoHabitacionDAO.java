package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.TipoHabitacion;
import Persistencia.ORM.DAOInterface.ITipoHabitacion;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoHabitacionDAO extends GenericDAO<TipoHabitacion, Integer> implements ITipoHabitacion {

    @Override
    public TipoHabitacion buscar(String nombre, int id) {
        Session session = getHibernateTemplate();
        List<TipoHabitacion> objetos = new ArrayList<TipoHabitacion>();
        try {
            String sql = "from TipoHabitacion where nombre = :nombre AND :id";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (objetos.isEmpty()) {
            return null;
        } else {
            return objetos.get(0);
        }
    }

    @Override
    public Object enUso(int id) {
        Session session = getHibernateTemplate();
        List<TipoHabitacion> objetos = new ArrayList<TipoHabitacion>();
        try {
            String sql = "select * from TipoHabitacion th inner join habitacion h ON th.id = h.id_tipohabitacion WHERE th.id LIKE :id ";
            objetos = session.createSQLQuery(sql).addEntity(TipoHabitacion.class).setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (objetos.isEmpty()) {
            return null;
        } else {
            return objetos.get(0);
        }
    }

    @Override
    public List<TipoHabitacion> getTodos(int id) {
        Session session = getHibernateTemplate();
        List<TipoHabitacion> objetos = new ArrayList<TipoHabitacion>();
        try {
            objetos = session.createQuery("from TipoHabitacion where id_hotel = :id").setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}//end TipoHabitacionDAO
