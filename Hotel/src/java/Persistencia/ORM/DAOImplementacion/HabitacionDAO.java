package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Habitacion;
import Persistencia.ORM.DAOInterface.IHabitacion;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class HabitacionDAO extends GenericDAO<Habitacion, Integer> implements IHabitacion {

    @Override
    public Habitacion buscar(String nombre, int id) {
        Session session = getHibernateTemplate();
        List<Habitacion> objetos = new ArrayList<Habitacion>();
        try {
            String sql = "select * from Habitacion h inner join TipoHabitacion tp ON h.id_tipohabitacion = tp.id WHERE tp.id_hotel = :id AND h.nombre = :nombre";
            objetos = session.createSQLQuery(sql).addEntity(Habitacion.class).setParameter("id", id).setParameter("nombre", nombre).list();
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
    public Habitacion enUso(int id) {
        Session session = getHibernateTemplate();
        List<Habitacion> objetos = new ArrayList<Habitacion>();
        try {
            String sql = "select * from Habitacion h inner join bloqueo b ON h.id = b.id_habitacion WHERE b.id = :id ";
            objetos = session.createSQLQuery(sql).addEntity(Habitacion.class).setParameter("id", id).list();
            if (objetos.isEmpty()) {
                sql = "select * from Habitacion h inner join detallemantenimiento dm ON h.id = dm.id_habitacion WHERE dm.id = :id ";
                objetos = session.createSQLQuery(sql).addEntity(Habitacion.class).setParameter("id", id).list();
                if (objetos.isEmpty()) {
                    //VALIDAR CON RESERVAS
                }
            }
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
    public List<Habitacion> getTodos(int id) {
        Session session = getHibernateTemplate();
        List<Habitacion> objetos = new ArrayList<Habitacion>();
        try {
            String sql = "select * from Habitacion h inner join TipoHabitacion tp ON h.id_tipohabitacion = tp.id WHERE tp.id_hotel = :id ";
            objetos = session.createSQLQuery(sql).addEntity(Habitacion.class).setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}//end HabitacionDAO
