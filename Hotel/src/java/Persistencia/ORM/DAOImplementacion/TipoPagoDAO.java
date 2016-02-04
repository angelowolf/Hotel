package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.TipoPago;
import Persistencia.ORM.DAOInterface.ITipoPago;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoPagoDAO extends GenericDAO<TipoPago, Integer> implements ITipoPago {

    public List<TipoPago> getTodos() {
        Session session = getHibernateTemplate();
        List<TipoPago> objetos = new ArrayList<TipoPago>();
        try {
            objetos = session.createQuery("from TipoPago").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public List<TipoPago> buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<TipoPago> objetos = new ArrayList<TipoPago>();
        try {
            String sql = "from TipoPago where nombre = :nombre";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public List<TipoPago> pagoEnUso(int id) {
        Session session = getHibernateTemplate();
        List<TipoPago> objetos = new ArrayList<TipoPago>();
        try {
            String sql = "select * from TipoPago tp inner join pago p ON tp.id = p.id WHERE tp.id LIKE :id ";
            objetos = session.createSQLQuery(sql).addEntity(TipoPago.class).setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}//end TipoPagoDAO
